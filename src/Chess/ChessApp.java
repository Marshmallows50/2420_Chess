package Chess;

import javax.swing.*;
import java.awt.*;

public class ChessApp extends JFrame {

    private JPanel contentPane;
    private JPanel boardPanel;
    private JMenuBar menuBar;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChessApp frame = new ChessApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ChessApp() {
        //frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Chess");
        setIconImage(new ImageIcon("src/Chess/Resources/icontest.png").getImage());
        setBounds(100, 100, 800, 800);

        //content pane
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        //panels and containers
        boardPanel = new JPanel(new GridLayout(8, 8, 0, 0));
        menuBar = new JMenuBar();

        //Add panels to contentPane
        contentPane.add(boardPanel, BorderLayout.CENTER);
        contentPane.add(menuBar, BorderLayout.NORTH);

    }
}
