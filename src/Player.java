public class Player {
    private Position currentPosition;

     public Player(int x, int y) {
        currentPosition = new Position(x, y);
    }

    public void move(int dx, int dy) {
        currentPosition.setX(currentPosition.getX() + dx);
        currentPosition.setY(currentPosition.getY() + dy);
    }

    public String getPosition(){
        return currentPosition.toString();
    }
}
