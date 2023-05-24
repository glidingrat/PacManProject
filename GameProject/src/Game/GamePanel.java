package Game;
import Entities.Player;
import Inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel  {


    private Game game;
    private JPanel panel, cell;

    public  int TILE_SIZE = 30;
    public  int TILES_IN_WIDTH = 15;
    public  int TILES_IN_HEIGHT = 15;
    public  int GAME_WIDTH = TILE_SIZE * TILES_IN_WIDTH;
    public  int GAME_HEIGHT = TILE_SIZE * TILES_IN_HEIGHT;

    private Player player;


    {
        try {
            player = new Player(30,35, 30, 30);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public GamePanel(Game game){
        this.game = game;

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
    }



    private void setPanelSize() {  //sets panel size by game height/width
        Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setPreferredSize(size);
    }


    public void paint(Graphics g) {  //paints map and playable characters
        super.paint(g);

        map();
        game.render(g);
    }


    public void map() {  //creates map
        panel = new JPanel(new GridLayout(TILES_IN_WIDTH, TILES_IN_HEIGHT));
        panel.setBorder(BorderFactory.createEmptyBorder(-5, 0, 0, 0)); // set the panel to the top

        for (int i = 0; i < TILES_IN_HEIGHT; i++) {
            for (int j = 0; j < TILES_IN_WIDTH; j++) {
                cell = new JPanel();
                cell.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE)); // set cell size to 30x30
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // set the background color of the cell based on the value in the map
                if (player.gameMap[i][j] == 5) {
                    cell.setBackground(Color.BLACK); // wall
                } else if (player.gameMap[i][j] == 1) {
                    cell.setBackground(Color.BLUE); // coin
                } else if (player.gameMap[i][j] == 0) {
                    cell.setBackground(Color.darkGray); // path
                }


                panel.add(cell); // add the cell to the panel
            }
        }

        add(panel, BorderLayout.CENTER); // add the panel to the frame

    }

    public Game getGame() {
        return game;
    }
}
