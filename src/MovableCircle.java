import Interfaces.Movable;

public class MovableCircle implements Movable {
    private final int radius;
    private final MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

//    public String toString() {
//        return
//    }

    @Override
    public void moveUp() {
        this.center.y = this.center.y++;
    }

    @Override
    public void moveDown() {
        this.center.y = this.center.y--;
    }

    @Override
    public void moveLeft() {
        this.center.x = this.center.x--;
    }

    @Override
    public void moveRight() {
        this.center.x = this.center.x++;
    }
}