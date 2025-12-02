import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            createAndShowGUI(args);
        });
    }

    private static void createAndShowGUI(String[] args) {

        JFrame mainFrame = new JFrame("Java GUI Projects");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 400);


        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new GridLayout(5, 1, 15, 15));


        JLabel titleLabel = new JLabel("Выберите задание:", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel);

        // Кнопка для задачи 1
        JButton task1Button = new JButton("Задача 1: Таблица результатов матчей");
        task1Button.setFont(new Font("Arial", Font.PLAIN, 14));
        task1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    MatchResultGUI matchGUI = new MatchResultGUI();
                    matchGUI.setVisible(true);
                });
            }
        });
        mainPanel.add(task1Button);

        // Кнопка для задачи 2
        JButton task2Button = new JButton("Задача 2: Случайные фигуры");
        task2Button.setFont(new Font("Arial", Font.PLAIN, 14));
        task2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    ShapesGUI shapesGUI = new ShapesGUI();
                    shapesGUI.setVisible(true);
                });
            }
        });
        mainPanel.add(task2Button);

        // Кнопка для задачи 3
        JButton task3Button = new JButton("Задача 3: Отображение картинки");
        task3Button.setFont(new Font("Arial", Font.PLAIN, 14));
        task3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    // Проверяем аргументы командной строки
                    String imagePath = null;
                    if (args.length > 0) {
                        imagePath = args[0];
                        System.out.println("Используется изображение: " + imagePath);
                    }
                    ImageDisplayGUI imageGUI = new ImageDisplayGUI(imagePath);
                    imageGUI.setVisible(true);
                });
            }
        });
        mainPanel.add(task3Button);

        // Кнопка для задачи 4
        JButton task4Button = new JButton("Задача 4: Анимация");
        task4Button.setFont(new Font("Arial", Font.PLAIN, 14));
        task4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    AnimationGUI animationGUI = new AnimationGUI();
                    animationGUI.setVisible(true);
                });
            }
        });
        mainPanel.add(task4Button);

        mainFrame.add(mainPanel);
        mainFrame.setLocationRelativeTo(null); // Центрируем окно
        mainFrame.setVisible(true);

        System.out.println("Главное окно запущено!");
    }
}