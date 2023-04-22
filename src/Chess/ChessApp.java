package Chess;

import edu.princeton.cs.algs4.ST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessApp extends JFrame {


    public Board board;
    private JPanel contentPane;
    private JPanel boardPanel;
    private JMenuBar menuBar;

    private ST<Tile, JButton> tButtonsST;


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
        // Init fields
        board = new Board();
        tButtonsST = new ST<>();

        //frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Chess");
        setIconImage(new ImageIcon("src/Chess/Resources/Pawn.png").getImage());
        setBounds(100, 100, 900, 900);
        setResizable(false);

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
        JPanel boardPanel = new JPanel(new GridLayout(8, 8, 0, 0));
        boardPanel.setSize(new Dimension(this.getWidth(), this.getHeight() - 50));

        Tile[] allTiles = board.grid.getKeys();
        for (Tile t:allTiles) {
            JButton button = new JButton();
            button.setBorder(null);
            button.setSize(new Dimension((boardPanel.getWidth()/8),(boardPanel.getHeight()/8)));

            // TODO: Reduce number of ImageIcon objects, currently creating 1 for each JButton, need to minimize.
            if (t.hasPiece())
                button.setIcon(new ImageIcon(t.getPiece().image.getScaledInstance
                        (button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT)));
            if (t.getColor().equals("B"))
                button.setBackground(Color.BLACK);
            else
                button.setBackground(Color.WHITE);

            button.addActionListener(new ActionListener() {
                @Override
                //TODO Don't select tiles without pieces on them.
                //Don't select a tile if player of opposite color to the piece on the tile clicks on it.
                public void actionPerformed(ActionEvent actionEvent) {
                    if (board.selectedTile != null) {
                        if (board.selectedTile.getColor().equals("B"))
                            tButtonsST.get(board.selectedTile).setBackground(Color.BLACK);
                        else
                            tButtonsST.get(board.selectedTile).setBackground(Color.WHITE);
                    }
                    board.select(t);
                    button.setBackground(Color.ORANGE);
                    //TODO Add other button functionality here
                }
            });
            tButtonsST.put(t, button);
            boardPanel.add(button);
        }
        return boardPanel;
    }
}
