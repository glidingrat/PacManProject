package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow  {

    private JLabel scoreLabel, wins;
    Font customFont = null;

    public GameWindow(GamePanel gamePanel){
        JFrame frame = new JFrame("Pac-Man vs Ghost");

        try { //uploads custom font
            customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Joystix.ttf"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //sets icon of jframe
        ImageIcon icon = new ImageIcon("res/Ghost/Ghost_left.png");
        frame.setIconImage(icon.getImage());

        JButton back = new JButton("BACK");
        back.setFont(customFont.deriveFont(30f));
        back.setFocusable(false);
        frame.getContentPane().add(back, BorderLayout.LINE_END );

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(customFont.deriveFont(30f));

        wins = new JLabel();
        frame.getContentPane().add(wins, BorderLayout.SOUTH);
        frame.getContentPane().add(scoreLabel, BorderLayout.NORTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);


        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // gets back into menu
                frame.dispose();

                new GameMenu.Menu();
            }
        });
    }


    public void updateScore(int score) {  //update score
        scoreLabel.setText("Score: " + score);
    }


    public void PM_WIN() {  // types when pacman win
        wins.setText("PAC-MAN WINS !");
        wins.setFont(customFont.deriveFont(49f));

    }

    public void GHOST_WIN() {  // types when ghost win
        wins.setText("GHOST WINS !");
        wins.setFont(customFont.deriveFont(55f));
    }

}
