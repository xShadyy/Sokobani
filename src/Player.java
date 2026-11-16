public class Player extends GameObject implements Movable {
    private int gridWidth;
    private int gridHeight;

    // Player constructor
    public Player(int x, int y, int gridWidth, int gridHeight) {
        super(x, y);
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    @Override
    public void move(int dx, int dy) {
        moveBy(dx, dy);
    }

    private void moveBy(long dx, long dy) {
        long nextX = getX() + dx;
        long nextY = getY() + dy;
        if (nextX >= 0 && nextX < gridWidth && nextY >= 0 && nextY < gridHeight) {
            getPosition().setX((int) nextX);
            getPosition().setY((int) nextY);
        } else {
            System.err.println("Cannot move to (" + nextX + ", " + nextY + "): position is outside the grid.");
        }
    }

    // MoveUp & movement validation
    public void moveUp(int dy) {
        move(0, dy);
    }

    // MoveDown & movement validation
    public void moveDown(int dy) {
        moveBy(0, -(long) dy);
    }

    // MoveLeft & movement validation
    public void moveLeft(int dx) {
        moveBy(-(long) dx, 0);
    }

    // MoveRight & movement validation
    public void moveRight(int dx) {
        move(dx, 0);
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
