import java.awt.*;

public class Triangle extends AbstractShape {

    public Triangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics2D g2d) {
        int[] xPoints = {x + width/2, x, x + width};
        int[] yPoints = {y, y + height, y + height};

        g2d.setColor(color);
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(xPoints, yPoints, 3);
    }
}