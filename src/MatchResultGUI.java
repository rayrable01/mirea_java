import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatchResultGUI extends JFrame {
    private int milanScore = 0;
    private int madridScore = 0;
    private String lastScorer = "N/A";
    private String winner = "DRAW";

    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    public MatchResultGUI() {
        setTitle("Футбольный матч: AC Milan vs Real Madrid");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BorderLayout());


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        JLabel titleLabel = new JLabel("ФУТБОЛЬНЫЙ МАТЧ", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 100, 0));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);


        JButton milanButton = new JButton("AC Milan");
        milanButton.setFont(new Font("Arial", Font.BOLD, 16));
        milanButton.setBackground(new Color(200, 0, 0)); // Красный
        milanButton.setForeground(Color.WHITE);
        milanButton.setPreferredSize(new Dimension(150, 50));
        milanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanScore++;
                lastScorer = "AC Milan";
                updateWinner();
                updateLabels();
            }
        });


        JButton madridButton = new JButton("Real Madrid");
        madridButton.setFont(new Font("Arial", Font.BOLD, 16));
        madridButton.setBackground(new Color(255, 215, 0)); // Золотой
        madridButton.setForeground(Color.BLACK);
        madridButton.setPreferredSize(new Dimension(150, 50));
        madridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madridScore++;
                lastScorer = "Real Madrid";
                updateWinner();
                updateLabels();
            }
        });


        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(milanButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(madridButton, gbc);


        resultLabel = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.WHITE);
        resultLabel.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(resultLabel, gbc);


        lastScorerLabel = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        lastScorerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 3;
        mainPanel.add(lastScorerLabel, gbc);


        winnerLabel = new JLabel("Winner: DRAW", SwingConstants.CENTER);
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        winnerLabel.setForeground(Color.BLUE);
        gbc.gridy = 4;
        mainPanel.add(winnerLabel, gbc);


        JButton resetButton = new JButton("Сбросить счет");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 14));
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanScore = 0;
                madridScore = 0;
                lastScorer = "N/A";
                winner = "DRAW";
                updateLabels();
            }
        });
        gbc.gridy = 5;
        mainPanel.add(resetButton, gbc);

        add(mainPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null); // Центрируем окно
    }

    private void updateWinner() {
        if (milanScore > madridScore) {
            winner = "AC Milan";
        } else if (madridScore > milanScore) {
            winner = "Real Madrid";
        } else {
            winner = "DRAW";
        }
    }

    private void updateLabels() {
        resultLabel.setText(String.format("Result: %d X %d", milanScore, madridScore));
        lastScorerLabel.setText("Last Scorer: " + lastScorer);
        winnerLabel.setText("Winner: " + winner);


        switch (winner) {
            case "AC Milan":
                winnerLabel.setForeground(new Color(200, 0, 0));
                break;
            case "Real Madrid":
                winnerLabel.setForeground(new Color(255, 215, 0));
                break;
            default:
                winnerLabel.setForeground(Color.BLUE);
        }
    }
}