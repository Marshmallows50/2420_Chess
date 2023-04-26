package Chess;

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
        setIconImage(new ImageIcon("src/Chess/Resources/wPawn.png").getImage());
        setBounds(100, 100, 900, 900);
        setResizable(false);

        //content pane
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));


        //panels and containers
        boardPanel = createBoardPanel();
        menuBar = createMenuBar();

        //TODO: get rid of small white border around the chess board
        //Add panels to contentPane
        contentPane.add(boardPanel, BorderLayout.CENTER);
        contentPane.add(menuBar, BorderLayout.NORTH);

        setContentPane(contentPane);
    }

    public JPanel createBoardPanel() {
        // create Panel
        JPanel boardPanel = new JPanel(new GridLayout(8,8));
        boardPanel.setSize(new Dimension(this.getWidth(), this.getHeight() - 50));

        // create and decorate buttons
        for (int i = 7, j =0; i >= 0 ; j++) { // loop through grid2d in reverse order to place A1 at bottom
            Tile t = game.board.grid2d[i][j];

            JButton button = new JButton();
            button.setBorder(null);
            button.setSize(new Dimension((boardPanel.getWidth()/8),(boardPanel.getHeight()/8)));

            if (t.hasPiece())
                button.setIcon(new ImageIcon(t.getPiece().image.getScaledInstance
                        (button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT)));
            button.setBackground(t.getColor());

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Tile selected = game.board.selectedPieceTile;
                    System.out.println(game.isWhitesTurn ? "It is white's turn." : "It is black's turn.");

                    // if player clicks on a tile without a piece before clicking
                    // on a tile with a piece, do nothing.
                    if (!t.hasPiece() && selected == null) {
                        System.out.println("select a tile with a piece first");
                        return;
                    }
                    // if player clicks on a tile with a piece of their color, select it.
                    else if (t.hasPiece() && game.isWhitesTurn == t.getPiece().getColor()) {
                        selectTile(t);
                        return;
                    }

                    // At this point, A piece and a destination have been selected.
                    if (game.isValidMovement(selected, t)) {
                        System.out.println("moving piece");
                        if (t.hasPiece())
                            game.kill(t.getPiece());

                        // moves piece to destination tile
                        selected.movePieceTo(t);
                        //update destination tile to reflect new piece
                        tButtonsST.get(t).setIcon(tButtonsST.get(selected).getIcon());
                        tButtonsST.get(selected).setIcon(null);
                        tButtonsST.get(selected).setBackground(selected.getColor());
                        //set selected piece back to null
                        game.board.selectedPieceTile = null;
                        game.isWhitesTurn = !game.isWhitesTurn;
                    }
                }
            });

            tButtonsST.put(t, button);
            boardPanel.add(button);

            if (j==7){
                i--;
                j=-1;}
        }
        return boardPanel;
    }

    public void selectTile(Tile t) {
        if (game.board.selectedPieceTile != null)
            tButtonsST.get(game.board.selectedPieceTile).setBackground(game.board.selectedPieceTile.getColor());
        game.board.selectedPieceTile = t;
        tButtonsST.get(game.board.selectedPieceTile).setBackground(Color.ORANGE);
        System.out.println("Player has selected a tile with a piece of their own color");
    }

    private JMenuBar createMenuBar() {
        // TODO: add DropDown menu, with reset button, exit game button.
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setSize(this.getWidth(), 50);

//        JPopupMenu gameOptions = new JPopupMenu("Game");
        JMenuItem reset = new JMenuItem("Reset Game");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                game = new Game();
//                tButtonsST = new ST<>();
//                boardPanel = createBoardPanel();
//                boardPanel.revalidate();
//                boardPanel.repaint();
            }
        });
//        gameOptions.add(reset);
        jMenuBar.add(reset);

        return jMenuBar;
    }
}
