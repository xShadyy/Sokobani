public class Box extends GameObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int dx, int dy) {
        getPosition().setX(getX() + dx);
        getPosition().setY(getY() + dy);
    }

    @Override
    public char getSymbol() {
        return 'B';
    }
}
