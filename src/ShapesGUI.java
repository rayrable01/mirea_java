import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapesGUI extends JFrame {
    private List<AbstractShape> shapes;
    private DrawingPanel drawingPanel;

    public ShapesGUI() {
        setTitle("Случайные фигуры");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        shapes = new ArrayList<>();
        Random random = new Random();

        // Создаем 20 случайных фигур
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(600);
            int y = random.nextInt(400);
            int width = 30 + random.nextInt(70);
            int height = 30 + random.nextInt(70);
            Color color = new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)
            );

            int shapeType = random.nextInt(3);
            AbstractShape shape;

            switch (shapeType) {
                case 0:
                    shape = new Circle(x, y, width, height, color);
                    break;
                case 1:
                    shape = new Rectangle(x, y, width, height, color);
                    break;
                case 2:
                    shape = new Triangle(x, y, width, height, color);
                    break;
                default:
                    shape = new Circle(x, y, width, height, color);
            }

            shapes.add(shape);
        }

        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        // Панель управления
        JPanel controlPanel = new JPanel();
        JButton regenerateButton = new JButton("Обновить фигуры");
        regenerateButton.addActionListener(e -> {
            shapes.clear();
            for (int i = 0; i < 20; i++) {
                int x = random.nextInt(600);
                int y = random.nextInt(400);
                int width = 30 + random.nextInt(70);
                int height = 30 + random.nextInt(70);
                Color color = new Color(
                        random.nextInt(256),
                        random.nextInt(256),
                        random.nextInt(256)
                );

                int shapeType = random.nextInt(3);
                AbstractShape shape;

                switch (shapeType) {
                    case 0:
                        shape = new Circle(x, y, width, height, color);
                        break;
                    case 1:
                        shape = new Rectangle(x, y, width, height, color);
                        break;
                    case 2:
                        shape = new Triangle(x, y, width, height, color);
                        break;
                    default:
                        shape = new Circle(x, y, width, height, color);
                }

                shapes.add(shape);
            }
            drawingPanel.repaint();
        });

        controlPanel.add(regenerateButton);
        add(controlPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    // Внутренний класс для рисования
    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Рисуем все фигуры
            for (AbstractShape shape : shapes) {
                shape.draw(g2d);
            }

            // Отображаем информацию
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
            g2d.drawString("Всего фигур: " + shapes.size(), 10, 20);

            // Подсчет типов фигур
            int circles = 0, rectangles = 0, triangles = 0;
            for (AbstractShape shape : shapes) {
                if (shape instanceof Circle) circles++;
                else if (shape instanceof Rectangle) rectangles++;
                else if (shape instanceof Triangle) triangles++;
            }

            g2d.drawString("Круги: " + circles, 10, 40);
            g2d.drawString("Прямоугольники: " + rectangles, 10, 60);
            g2d.drawString("Треугольники: " + triangles, 10, 80);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 500);
        }
    }
}