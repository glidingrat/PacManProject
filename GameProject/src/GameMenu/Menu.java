package GameMenu;

import Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    Font customFont = null;

    public Menu(){
        JFrame frame = new JFrame("Pac-Man Menu");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        try { //uploads custom font
            customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Joystix.ttf"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //sets icon of jframe
        ImageIcon icon = new ImageIcon("res/PacMan/PM_right.png");
        frame.setIconImage(icon.getImage());

        //creating labels and buttons
        JLabel titleLabel = new JLabel("PAC-MAN");
        JButton startButton = new JButton("Start Game");
        JButton controlButton = new JButton("Help");
        JButton exitButton = new JButton("Exit");

        //sets font for labels and button
        titleLabel.setFont(customFont.deriveFont(50f));
        startButton.setFont(customFont.deriveFont(30f));
        startButton.setFocusable(false);
        controlButton.setFont(customFont.deriveFont(30f));
        controlButton.setFocusable(false);
        exitButton.setFont(customFont.deriveFont(30f));
        exitButton.setFocusable(false);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // set layout to vertical box layout

        //sets labels and button to center
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Adds labels and buttons to the panel
        panel.add(Box.createVerticalStrut(10));
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(60));
        panel.add(startButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(controlButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(exitButton);

        panel.setBackground(Color.lightGray); // sets background color

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Opens the game
                frame.dispose();

                new Game();
            }
        });


        controlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the help menu
                frame.dispose();

                new HelpMenu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exit the game
                System.exit(0);
            }
        });


    }
}
