import Interfaces.Movable;

public class MovablePoint implements Movable {
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        this.y = y++;
    }

    @Override
    public void moveDown() {
        this.y = y--;
    }

    @Override
    public void moveLeft() {
        this.x = x--;
    }

    @Override
    public void moveRight() {
        this.x = x++;
    }
}
