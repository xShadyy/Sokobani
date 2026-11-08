public class Game {
    public static void main(String[] args) {
        Player player = new Player(1, 1, 7, 7);
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

        for (int row = 0; row < player.getGridHeight(); row++) {
            for (int column = 0; column < player.getGridWidth(); column++) {
                GameObject object = getObjectAt(objects, column, row);
                System.out.print((object == null ? '.' : object.getSymbol()) + " ");
            }
            System.out.println();
        }
    }

    private static GameObject getObjectAt(GameObject[] objects, int x, int y) {
        for (GameObject object : objects) {
            if (object.getX() == x && object.getY() == y) {
                return object;
            }
        }
        return null;
    }
}
