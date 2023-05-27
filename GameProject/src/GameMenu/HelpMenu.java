package GameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HelpMenu {
    Font customFont = null;

    HelpMenu(){
        JFrame frame = new JFrame("Help Menu");

        try { // uploads custom font
            customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Joystix.ttf"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //sets icon of jframe
        ImageIcon icon = new ImageIcon("res/PacMan/PM_left.png");
        frame.setIconImage(icon.getImage());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // set layout to vertical box layout

        //creating labels and button
        JLabel title = new JLabel("Controls");
        JLabel who = new JLabel("PAC-MAN       GHOST");
        JLabel w = new JLabel("W                           ↑ ");
        JLabel a = new JLabel("A    S    D              ←    ↓    →");
        JLabel htp = new JLabel("<html>How to play:<br>Pac-Man gets a point by going through blue tile.<br>Score 3 points, then Pac-Man can kill Ghost.<br>Ghost must kill Pac-Man before he takes 3 points.</html>");
        JButton back = new JButton("BACK");
        back.setFocusable(false);


        //adding labels and button to the panel
        panel.add(title);
        panel.add(Box.createVerticalStrut(50));
        panel.add(who);
        panel.add(Box.createVerticalStrut(20));
        panel.add(w);
        panel.add(Box.createVerticalStrut(5));
        panel.add(a);
        panel.add(Box.createVerticalStrut(10));
        panel.add(htp);
        panel.add(Box.createVerticalStrut(40));
        panel.add(back);

        //sets font for labels and button
        title.setFont(customFont.deriveFont(30f));
        who.setFont(customFont.deriveFont(30f));
        w.setFont(new Font("Calibri", Font.BOLD, 30));
        a.setFont(new Font("Calibri", Font.BOLD, 30));
        htp.setFont(new Font("Calibri", Font.BOLD, 20));
        back.setFont(customFont.deriveFont(30f));


        //sets labels and button to center
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        who.setAlignmentX(Component.CENTER_ALIGNMENT);
        w.setAlignmentX(Component.CENTER_ALIGNMENT);
        a.setAlignmentX(Component.CENTER_ALIGNMENT);
        htp.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setBackground(Color.lightGray);

        frame.add(panel);

        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //gets back to the menu
                frame.dispose();

                new Menu();
            }
        });

    }
}
