import AbstractClasses.Shape;

public class Circle extends Shape {
    protected double radius;

    public Circle() {
        super();
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    };

    public void setRadius(double radius) {
        this.radius = radius;
    };

    @Override
    public double getArea() {
        return 3.14159 * Math.pow(this.radius, 2);
    };
    @Override
    public double getPerimeter() {
        return 2 * 3.14159 * this.radius;
    };
    @Override
    public String toString() {
        return "Circle[radius=" + this.radius + ", color=" + color + ", filled=" + filled + "]";
    };
}
