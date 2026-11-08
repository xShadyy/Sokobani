public class Player extends GameObject {
    private int gridWidth;
    private int gridHeight;

    // Player constructor
    public Player(int x, int y, int gridWidth, int gridHeight) {
        super(x, y);
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    // MoveUp & movement validation
    public void moveUp(int dy) {
        long nextY = getY() + (long) dy;
        if (nextY >= 0 && nextY < gridHeight) {
            getPosition().setY((int) nextY);
        } else {
            System.err.println("Cannot move to (" + getX() + ", " + nextY + "): position is outside the grid.");
        }
    }

    // MoveDown & movement validation
    public void moveDown(int dy) {
        long nextY = getY() - (long) dy;
        if (nextY >= 0 && nextY < gridHeight) {
            getPosition().setY((int) nextY);
        } else {
            System.err.println("Cannot move to (" + getX() + ", " + nextY + "): position is outside the grid.");
        }
    }

    // MoveLeft & movement validation
    public void moveLeft(int dx) {
        long nextX = getX() - (long) dx;
        if (nextX >= 0 && nextX < gridWidth) {
            getPosition().setX((int) nextX);
        } else {
            System.err.println("Cannot move to (" + nextX + ", " + getY() + "): position is outside the grid.");
        }
    }

    // MoveRight & movement validation
    public void moveRight(int dx) {
        long nextX = getX() + (long) dx;
        if (nextX >= 0 && nextX < gridWidth) {
            getPosition().setX((int) nextX);
        } else {
            System.err.println("Cannot move to (" + nextX + ", " + getY() + "): position is outside the grid.");
        }
    }

    @Override
    public char getSymbol() {
        return 'P';
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
