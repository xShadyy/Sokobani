public abstract class GameObject {
    private final Position position;

    protected GameObject(int x, int y) {
        position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public abstract char getSymbol();

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }
}
