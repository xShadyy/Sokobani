public class Player {
    private Position currentPosition;
    private int gridWidth;
    private int gridHeight;

    // Player constructor
    public Player(int x, int y, int gridWidth, int gridHeight) {
        currentPosition = new Position(x, y);
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    // MoveUp & movement validation
    public void moveUp(int dy) {
        long nextY = currentPosition.getY() + (long) dy;
        if (nextY >= 0 && nextY < gridHeight) {
            currentPosition.setY((int) nextY);
        } else {
            System.err.println("Cannot move to (" + currentPosition.getX() + ", " + nextY + "): position is outside the grid.");
        }
    }

    // MoveDown & movement validation
    public void moveDown(int dy) {
        long nextY = currentPosition.getY() - (long) dy;
        if (nextY >= 0 && nextY < gridHeight) {
            currentPosition.setY((int) nextY);
        } else {
            System.err.println("Cannot move to (" + currentPosition.getX() + ", " + nextY + "): position is outside the grid.");
        }
    }

    // MoveLeft & movement validation
    public void moveLeft(int dx) {
        long nextX = currentPosition.getX() - (long) dx;
        if (nextX >= 0 && nextX < gridWidth) {
            currentPosition.setX((int) nextX);
        } else {
            System.err.println("Cannot move to (" + nextX + ", " + currentPosition.getY() + "): position is outside the grid.");
        }
    }

    // MoveRight & movement validation
    public void moveRight(int dx) {
        long nextX = currentPosition.getX() + (long) dx;
        if (nextX >= 0 && nextX < gridWidth) {
            currentPosition.setX((int) nextX);
        } else {
            System.err.println("Cannot move to (" + nextX + ", " + currentPosition.getY() + "): position is outside the grid.");
        }
    }

    // Position getter as a string eg. (2,1)
    public String getPosition(){
        return currentPosition.toString();
    }

    // X cordinate getter
    public int getX() {
        return currentPosition.getX();
    }

    // Y cordinate getter
    public int getY() {
        return currentPosition.getY();
    }

    // gridWidth getter
    public int getGridWidth() {
        return gridWidth;
    }

    // gridHeight getter
    public int getGridHeight() {
        return gridHeight;
    }
}
