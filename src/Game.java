public class Game {
    public static void main(String[] args) {
        
        // Init. player object with given parameters
        Player player = new Player(2, 2, 5, 5);
        int[][] grid = new int[player.getGridHeight()][player.getGridWidth()];

        player.moveRight(5);

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (player.getX() == column && player.getY() == row) {
                    System.out.print("P ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
