package Inputs;

import Game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()){
            // PacMan
            case KeyEvent.VK_W:
                gamePanel.getGame().getPlayer().setUp(true);
                gamePanel.getGame().getPlayer().setPMDirection(1);
                break;
            case KeyEvent.VK_A:
                gamePanel.getGame().getPlayer().setLeft(true);
                gamePanel.getGame().getPlayer().setPMDirection(2);
                break;
            case KeyEvent.VK_S:
                gamePanel.getGame().getPlayer().setDown(true);
                gamePanel.getGame().getPlayer().setPMDirection(3);
                break;
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setRight(true);
                gamePanel.getGame().getPlayer().setPMDirection(4);
                break;

            //Ghost
            case KeyEvent.VK_UP:
                gamePanel.getGame().getEnemy().setUp(true);
                gamePanel.getGame().getEnemy().setGDirection(1);
                break;
            case KeyEvent.VK_LEFT:
                gamePanel.getGame().getEnemy().setLeft(true);
                gamePanel.getGame().getEnemy().setGDirection(2);
                break;
            case KeyEvent.VK_DOWN:
                gamePanel.getGame().getEnemy().setDown(true);
                gamePanel.getGame().getEnemy().setGDirection(3);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getEnemy().setRight(true);
                gamePanel.getGame().getEnemy().setGDirection(4);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()){
            //PacMan
            case KeyEvent.VK_W:
                gamePanel.getGame().getPlayer().setUp(false);
                break;
            case KeyEvent.VK_A:
                gamePanel.getGame().getPlayer().setLeft(false);
                break;
            case KeyEvent.VK_S:
                gamePanel.getGame().getPlayer().setDown(false);
                break;
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setRight(false);
                break;

            //Ghost
            case KeyEvent.VK_UP:
                gamePanel.getGame().getEnemy().setUp(false);
                break;
            case KeyEvent.VK_LEFT:
                gamePanel.getGame().getEnemy().setLeft(false);
                break;
            case KeyEvent.VK_DOWN:
                gamePanel.getGame().getEnemy().setDown(false);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getEnemy().setRight(false);
                break;
        }
    }
}
