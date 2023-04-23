package Chess;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.ST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessApp extends JFrame {

    public Game game;
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
        game = new Game();

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

        Tile[] allTiles = game.board.grid.getKeys();
        for (int i = allTiles.length - 1; i >= 0; i--) {
            Tile t = allTiles[i];
            JButton button = new JButton(t.getName());
            button.setBorder(null);
            button.setSize(new Dimension((boardPanel.getWidth()/8),(boardPanel.getHeight()/8)));

            // TODO: Reduce number of ImageIcon objects, currently creating 1 for each JButton, need to minimize.
            if (t.hasPiece())
                button.setIcon(new ImageIcon(t.getPiece().image.getScaledInstance
                        (button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT)));
            button.setBackground(t.getColor());

            button.addActionListener(new ActionListener() {
                @Override
                //TODO Don't select tiles without pieces on them.
                //TODO Don't select a tile if player of opposite color to the piece on the tile clicks on it.
                public void actionPerformed(ActionEvent actionEvent) {
                    Tile selectedTile = game.board.selectedTile;
                    if (!t.hasPiece() && selectedTile == null)
                        return;
                    else if(selectedTile == null && t.getPiece().getColor() == game.isWhitesTurn) {
                        game.board.select(t);
                        button.setBackground(Color.ORANGE);
                        return;
                    } else if(selectedTile.getPiece().getColor() == game.isWhitesTurn && game.bfpsManager.pieceHasPathTo(selectedTile, t)) {
                        System.out.println("moving piece");
                        selectedTile.movePiece(t);
                        tButtonsST.get(t).setIcon(tButtonsST.get(selectedTile).getIcon());
                        tButtonsST.get(selectedTile).setIcon(null);
                        tButtonsST.get(selectedTile).setBackground(selectedTile.getColor());
                        game.board.selectedTile = null;
                        if(game.isWhitesTurn)
                            game.isWhitesTurn = false;
                        else
                            game.isWhitesTurn = true;
                        return;
                    } else {
                        System.out.println("todo");
                    }

                    //TODO Add other button functionality here
                }
            });
            tButtonsST.put(t, button);
            boardPanel.add(button);
        }
        return boardPanel;
    }
}
