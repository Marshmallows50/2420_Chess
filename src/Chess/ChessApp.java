package Chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessApp extends JFrame {


    public Board board;
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
        board = new Board();

        //frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Chess");
        setIconImage(new ImageIcon("src/Chess/Resources/Pawn.png").getImage());
        setBounds(100, 100, 800, 800);

        //content pane
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));

        //panels and containers
//        boardPanel = new JPanel(new GridLayout(8, 8, 0, 0));
        boardPanel = createBoardPanel();
//        menuBar = new JMenuBar();

        //Add panels to contentPane
        contentPane.add(boardPanel, BorderLayout.CENTER);
//        contentPane.add(menuBar, BorderLayout.NORTH);

        setContentPane(contentPane);
    }

    public JPanel createBoardPanel() {
        //TODO fix image icon sizing issues. Look at https://stackoverflow.com/questions/2244848/java-imageicon-size
        JPanel boardPanel = new JPanel(new GridLayout(8, 8, 0, 0));
        boardPanel.setMinimumSize(new Dimension(this.getWidth(), this.getHeight() - 50));
        Tile[] allTiles = board.grid.getKeys();
        for (Tile t:allTiles) {
            JButton button = new JButton();
            if (t.hasPiece())
                button.setIcon(t.getPiece().icon);
            if (t.getColor().equals("B"))
                button.setBackground(Color.BLACK);

            button.setBorder(null);
            button.setMinimumSize(new Dimension
                    ((boardPanel.getWidth()/8)-5,(boardPanel.getHeight())-5));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    board.select(t);
                    button.setBackground(Color.ORANGE);
                    //TODO Add other button functionality here
                }
            });
            boardPanel.add(button);
        }
        return boardPanel;
    }
}
