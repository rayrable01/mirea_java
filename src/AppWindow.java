import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {

    private JTextField field;
    private JButton button1;
    private JButton button2;

    public AppWindow() {
        setTitle("Пример программы");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        field = new JTextField();
        button1 = new JButton("Кнопка 1");
        button2 = new JButton("Кнопка 2");

        JPanel panel = new JPanel();
        panel.add(button1);
        panel.add(button2);

        setJMenuBar(MenuFactory.create(field));
        add(field, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }
}
