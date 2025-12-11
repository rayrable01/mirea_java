import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.DataFlavor;

public class MenuFactory {

    public static JMenuBar create(JTextField field) {
        JMenuBar bar = new JMenuBar();

        JMenu file = new JMenu("Файл");
        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem exit = new JMenuItem("Выйти");
        exit.addActionListener(e -> System.exit(0));
        file.add(save);
        file.add(exit);

        JMenu edit = new JMenu("Правка");
        JMenuItem copy = new JMenuItem("Копировать");
        JMenuItem cut = new JMenuItem("Вырезать");
        JMenuItem paste = new JMenuItem("Вставить");

        copy.addActionListener(e ->
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                        new StringSelection(field.getText()), null)
        );

        cut.addActionListener(e -> {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                    new StringSelection(field.getText()), null);
            field.setText("");
        });

        paste.addActionListener(e -> {
            try {
                String text = (String) Toolkit.getDefaultToolkit()
                        .getSystemClipboard()
                        .getData(DataFlavor.stringFlavor);
                field.setText(text);
            } catch (Exception ignored) {}
        });

        edit.add(copy);
        edit.add(cut);
        edit.add(paste);

        JMenu help = new JMenu("Справка");
        JMenuItem about = new JMenuItem("О программе");
        about.addActionListener(e ->
                JOptionPane.showMessageDialog(null, "Учебная программа по Swing."));
        help.add(about);

        bar.add(file);
        bar.add(edit);
        bar.add(help);

        return bar;
    }
}
