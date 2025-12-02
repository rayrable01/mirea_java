import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageDisplayGUI extends JFrame {
    private JLabel imageLabel;
    private String currentImagePath;

    public ImageDisplayGUI(String imagePath) {
        setTitle("Просмотр изображений");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        imageLabel = new JLabel("", SwingConstants.CENTER);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(imageLabel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);

        // Панель управления
        JPanel controlPanel = new JPanel();

        JButton loadButton = new JButton("Загрузить изображение");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImage();
            }
        });

        controlPanel.add(loadButton);

        add(controlPanel, BorderLayout.SOUTH);

        // Загружаем изображение из аргументов или по умолчанию
        if (imagePath != null && new File(imagePath).exists()) {
            loadImage(imagePath);
        } else {
            // Пробуем загрузить изображение по умолчанию
            loadDefaultImage();
        }

        setLocationRelativeTo(null);
    }

    private void loadImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберите изображение");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Фильтр для изображений
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) return true;
                String name = f.getName().toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".jpeg") ||
                        name.endsWith(".png") || name.endsWith(".gif") ||
                        name.endsWith(".bmp");
            }

            @Override
            public String getDescription() {
                return "Изображения (*.jpg, *.jpeg, *.png, *.gif, *.bmp)";
            }
        });

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            loadImage(selectedFile.getAbsolutePath());
        }
    }

    private void loadImage(String imagePath) {
        try {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage();

            // Масштабируем изображение, если оно слишком большое
            int maxWidth = 800;
            int maxHeight = 600;

            int originalWidth = imageIcon.getIconWidth();
            int originalHeight = imageIcon.getIconHeight();

            if (originalWidth > maxWidth || originalHeight > maxHeight) {
                double scaleFactor = Math.min(
                        (double) maxWidth / originalWidth,
                        (double) maxHeight / originalHeight
                );

                int newWidth = (int) (originalWidth * scaleFactor);
                int newHeight = (int) (originalHeight * scaleFactor);

                image = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            }

            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
            currentImagePath = imagePath;

            // Обновляем заголовок окна
            File file = new File(imagePath);
            setTitle("Просмотр изображения: " + file.getName());

            imageLabel.setText("");
        } catch (Exception e) {
            imageLabel.setIcon(null);
            imageLabel.setText("Ошибка загрузки изображения!");
            JOptionPane.showMessageDialog(this,
                    "Не удалось загрузить изображение: " + e.getMessage(),
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadDefaultImage() {
        // Пробуем загрузить стандартную иконку или показываем сообщение
        try {
            // Создаем простое изображение для демонстрации
            ImageIcon icon = createDefaultIcon();
            imageLabel.setIcon(icon);
            imageLabel.setText("");
            setTitle("Просмотр изображения: (нет изображения)");
        } catch (Exception e) {
            imageLabel.setIcon(null);
            imageLabel.setText("<html><center>Изображение не загружено<br>" +
                    "Укажите путь к изображению в аргументах<br>" +
                    "или нажмите 'Загрузить изображение'</center></html>");
        }
    }

    private ImageIcon createDefaultIcon() {
        // Создаем простое изображение для демонстрации
        java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(
                400, 300, java.awt.image.BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = image.createGraphics();

        // Градиентный фон
        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(200, 220, 255),
                400, 300, new Color(255, 255, 200));
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, 400, 300);

        // Текст
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Пример изображения", 100, 100);

        // Простые фигуры
        g2d.setColor(new Color(255, 100, 100));
        g2d.fillOval(50, 150, 100, 100);

        g2d.setColor(new Color(100, 255, 100));
        g2d.fillRect(200, 150, 100, 100);

        g2d.setColor(new Color(100, 100, 255));
        int[] xPoints = {350, 300, 400};
        int[] yPoints = {150, 250, 250};
        g2d.fillPolygon(xPoints, yPoints, 3);

        g2d.dispose();

        return new ImageIcon(image);
    }
}