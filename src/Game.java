import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Player player = new Player(3, 2, 7, 7);
        GameObject[] objects = {
            player,
            new Target(4, 5),
            new Box(3, 3),
            new Wall(0, 0),
            new Wall(1, 0),
            new Wall(2, 0),
            new Wall(3, 0),
            new Wall(4, 0),
            new Wall(5, 0),
            new Wall(6, 0),
            new Wall(0, 1),
            new Wall(6, 1),
            new Wall(0, 2),
            new Wall(6, 2),
            new Wall(0, 3),
            new Wall(3, 4),
            new Wall(6, 3),
            new Wall(0, 4),
            new Wall(6, 4),
            new Wall(0, 5),
            new Wall(6, 5),
            new Wall(0, 6),
            new Wall(1, 6),
            new Wall(2, 6),
            new Wall(3, 6),
            new Wall(4, 6),
            new Wall(5, 6),
            new Wall(6, 6)
        };

        printGrid(objects, player);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter move (w/a/s/d, q to quit): ");
                if (!scanner.hasNextLine()) {
                    break;
                }

                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("q")) {
                    break;
                }

                int dx;
                int dy;
                if (input.equals("w")) {
                    dx = 0;
                    dy = -1;
                } else if (input.equals("s")) {
                    dx = 0;
                    dy = 1;
                } else if (input.equals("a")) {
                    dx = -1;
                    dy = 0;
                } else if (input.equals("d")) {
                    dx = 1;
                    dy = 0;
                } else {
                    System.out.println("Unknown move.");
                    continue;
                }

                tryMovePlayer(objects, player, dx, dy);
                printGrid(objects, player);
            }
        }
    }

    private static void printGrid(GameObject[] objects, Player player) {
        for (int row = 0; row < player.getGridHeight(); row++) {
            for (int column = 0; column < player.getGridWidth(); column++) {
                GameObject object = getObjectAt(objects, column, row);
                System.out.print((object == null ? '.' : object.getSymbol()) + " ");
            }
            System.out.println();
        }
    }

    private static void tryMovePlayer(GameObject[] objects, Player player, int dx, int dy) {
        long destinationX = player.getX() + (long) dx;
        long destinationY = player.getY() + (long) dy;
        if (destinationX < 0 || destinationX >= player.getGridWidth()
                || destinationY < 0 || destinationY >= player.getGridHeight()) {
            System.out.println("Cannot move outside the grid.");
            return;
        }

        GameObject destination = getObjectAt(objects, (int) destinationX, (int) destinationY);
        if (destination instanceof Wall) {
            System.out.println("Bump into wall.");
            return;
        }

        if (destination instanceof Movable) {
            long boxX = destinationX + dx;
            long boxY = destinationY + dy;
            if (boxX < 0 || boxX >= player.getGridWidth()
                    || boxY < 0 || boxY >= player.getGridHeight()) {
                System.out.println("Cannot push the box outside the grid.");
                return;
            }

            GameObject behindBox = getObjectAt(objects, (int) boxX, (int) boxY);
            if (behindBox instanceof Wall || behindBox instanceof Movable) {
                System.out.println("The box cannot be pushed.");
                return;
            }

            ((Movable) destination).move(dx, dy);
        }

        player.move(dx, dy);
    }

    private static GameObject getObjectAt(GameObject[] objects, int x, int y) {
        GameObject target = null;
        for (GameObject object : objects) {
            if (object.getX() == x && object.getY() == y) {
                if (!(object instanceof Target)) {
                    return object;
                }
                target = object;
            }
        }
        return target;
    }
}
