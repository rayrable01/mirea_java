import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AnimationGUI extends JFrame {
    private AnimationPanel animationPanel;
    private Timer timer;
    private int currentFrame = 0;
    private List<ImageIcon> frames;
    private boolean isPlaying = true;

    public AnimationGUI() {
        setTitle("Анимация из нескольких кадров");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());


        frames = createAnimationFrames();

        animationPanel = new AnimationPanel();
        add(animationPanel, BorderLayout.CENTER);


        JPanel controlPanel = new JPanel();

        JButton playPauseButton = new JButton("Пауза");
        playPauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying) {
                    timer.stop();
                    playPauseButton.setText("Воспроизвести");
                } else {
                    timer.start();
                    playPauseButton.setText("Пауза");
                }
                isPlaying = !isPlaying;
            }
        });

        JButton slowerButton = new JButton("Медленнее");
        slowerButton.addActionListener(e -> {
            int delay = timer.getDelay();
            if (delay < 500) {
                timer.setDelay(delay + 50);
            }
        });

        JButton fasterButton = new JButton("Быстрее");
        fasterButton.addActionListener(e -> {
            int delay = timer.getDelay();
            if (delay > 50) {
                timer.setDelay(delay - 50);
            }
        });

        JButton resetButton = new JButton("Сброс");
        resetButton.addActionListener(e -> {
            currentFrame = 0;
            animationPanel.repaint();
        });

        controlPanel.add(playPauseButton);
        controlPanel.add(slowerButton);
        controlPanel.add(fasterButton);
        controlPanel.add(resetButton);

        add(controlPanel, BorderLayout.SOUTH);


        JPanel infoPanel = new JPanel();
        JLabel infoLabel = new JLabel("Кадр: 1/" + frames.size() + " | Скорость: 100 мс");
        infoPanel.add(infoLabel);
        add(infoPanel, BorderLayout.NORTH);


        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame = (currentFrame + 1) % frames.size();
                animationPanel.repaint();
                infoLabel.setText(String.format("Кадр: %d/%d | Скорость: %d мс",
                        currentFrame + 1, frames.size(), timer.getDelay()));
            }
        });

        timer.start();
        setLocationRelativeTo(null);
    }

    private List<ImageIcon> createAnimationFrames() {
        List<ImageIcon> frames = new ArrayList<>();


        for (int i = 0; i < 6; i++) {
            BufferedImage frame = new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = frame.createGraphics();


            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // Фон
            g2d.setColor(new Color(240, 240, 255));
            g2d.fillRect(0, 0, 400, 300);

            // Вращающийся квадрат
            g2d.translate(200, 150);
            g2d.rotate(Math.toRadians(i * 60)); // 60 градусов на кадр

            // Рисуем сложную фигуру
            GradientPaint gradient = new GradientPaint(
                    -50, -50, new Color(255, 100, 100, 200),
                    50, 50, new Color(100, 100, 255, 200));
            g2d.setPaint(gradient);

            // Основная фигура
            g2d.fillRoundRect(-50, -50, 100, 100, 20, 20);

            // Детали
            g2d.setColor(new Color(255, 255, 255, 150));
            g2d.fillOval(-30, -30, 20, 20);
            g2d.fillOval(10, -30, 20, 20);
            g2d.fillOval(-30, 10, 20, 20);
            g2d.fillOval(10, 10, 20, 20);

            // Контур
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawRoundRect(-50, -50, 100, 100, 20, 20);

            g2d.dispose();

            frames.add(new ImageIcon(frame));
        }


        for (int i = 0; i < 6; i++) {
            BufferedImage frame = new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = frame.createGraphics();

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // Фон с изменяющимся цветом
            Color bgColor = Color.getHSBColor(i / 6.0f, 0.3f, 0.9f);
            g2d.setColor(bgColor);
            g2d.fillRect(0, 0, 400, 300);

            // Анимированный круг
            int radius = 40 + i * 5;
            g2d.setColor(new Color(255, 200, 100, 200));
            g2d.fillOval(200 - radius, 150 - radius, radius * 2, radius * 2);

            // Вращающиеся линии
            g2d.setColor(new Color(0, 100, 200));
            g2d.setStroke(new BasicStroke(3));
            for (int j = 0; j < 8; j++) {
                double angle = Math.toRadians(j * 45 + i * 30);
                int x2 = (int) (200 + Math.cos(angle) * 60);
                int y2 = (int) (150 + Math.sin(angle) * 60);
                g2d.drawLine(200, 150, x2, y2);
            }

            g2d.dispose();

            frames.add(new ImageIcon(frame));
        }

        return frames;
    }


    private class AnimationPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Очищаем панель
            g2d.setColor(new Color(245, 245, 245));
            g2d.fillRect(0, 0, getWidth(), getHeight());

            // Отображаем текущий кадр
            if (!frames.isEmpty()) {
                ImageIcon currentIcon = frames.get(currentFrame);
                Image image = currentIcon.getImage();

                // Центрируем изображение
                int x = (getWidth() - image.getWidth(null)) / 2;
                int y = (getHeight() - image.getHeight(null)) / 2;

                g2d.drawImage(image, x, y, null);
            }

            // Отображаем информацию о кадре
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.PLAIN, 12));
            g2d.drawString("Кадр " + (currentFrame + 1) + " из " + frames.size(), 10, 20);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 400);
        }
    }
}