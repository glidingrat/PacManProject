package Game;

import Entities.Enemy;
import Entities.Player;
import java.awt.*;
import java.io.IOException;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;

    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    private Player player;
    private Enemy enemy;


    public Game(){
        initClasses();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();


        startGameLoop();
    }


    private void initClasses() {  //loads all playable characters

        try {
            player = new Player(30,30, 30, 30);
            enemy = new Enemy(390,390,30,30);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void startGameLoop() {  //starts game loop
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void update() {  // updating characters and score
        player.update();
        enemy.update();
        gameWindow.updateScore(player.getScore());
        checkCollision();

    }


    public void render(Graphics g) {  //renders playable characters
        player.renderPM(g);
        enemy.renderG(g);
    }

    public void checkCollision() {  //checks for collision
        if (enemy.collidesWith(player)){
            if(player.getScore() == 3) {
                gameWindow.PM_WIN();
            } else {
                gameWindow.GHOST_WIN();
            }
        }
    }




    @Override
    public void run() {   // game loop

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;


        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU  = 0;
        double deltaF = 0;

        while(true){

            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1){
                update();

                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();

                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
