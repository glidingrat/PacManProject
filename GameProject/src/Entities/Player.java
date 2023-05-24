package Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class Player extends Entity {
    private BufferedImage PM_UP, PM_DOWN, PM_LEFT, PM_RIGHT;
    private boolean left, up, right, down;
    private int direction = 4;
    private int speed = 1;
    private int score = 0;

    public int[][] gameMap = {
            {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
            {5, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 1, 5},
            {5, 0, 5, 5, 0, 5, 0, 5, 0, 5, 0, 5, 5, 0, 5},
            {5, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 5},
            {5, 0, 5, 5, 0, 5, 5, 5, 5, 5, 0, 5, 5, 0, 5},
            {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
            {5, 5, 5, 5, 0, 5, 5, 0, 5, 5, 0, 5, 5, 5, 5},
            {5, 0, 0, 0, 0, 5, 0, 1, 0, 5, 0, 0, 0, 0, 5},
            {5, 0, 5, 5, 0, 0, 0, 5, 0, 0, 0, 5, 5, 0, 5},
            {5, 0, 5, 0, 0, 5, 0, 5, 0, 5, 0, 0, 5, 0, 5},
            {5, 0, 5, 0, 5, 5, 0, 5, 0, 5, 5, 0, 5, 0, 5},
            {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
            {5, 0, 5, 5, 0, 5, 0, 5, 0, 5, 0, 5, 5, 0, 5},
            {5, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 1, 5},
            {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}
    };



    public Player(int x, int y, int width, int height) throws IOException {
        super(x, y, width, height);

        load();
    }

    public void update(){  //updates position and hitbox placement
        updatePosition();
        updateHitbox();
    }


    public void renderPM(Graphics g) {   // render image in right direction

        if (direction == 1) {
            g.drawImage(PM_UP, x, y, null);
        } else if (direction == 2) {
            g.drawImage(PM_LEFT, x, y, null);
        } else if (direction == 3) {
            g.drawImage(PM_DOWN, x, y, null);
        } else if (direction == 4) {
            g.drawImage(PM_RIGHT, x, y, null);
        }

        drawHitbox(g);
    }

    public void coinAdd() {   // check for coin (tile 1) and add point and remove the coin tile
        if (gameMap[(y)/30][(x)/30] == 1) {
            score++;
            gameMap[(y)/30][(x)/30] = 0;
        }
    }


    public void updatePosition() {

        // "if" is there so you can hold two keys at once
        if (left && !right) {
            //Check if there is no wall(tile 5) to the left, and move left by the value of speed.
            if (gameMap[y/30][(x-1)/30] != 5 && gameMap[(y+29)/30][(x-1)/30] != 5) {
                x -= speed;

                coinAdd();
            }
        }else if (right && !left) {
            //Check if there is no wall(tile 5) to the right, and move left by the value of speed.
            if (gameMap[(y)/30][(x+30)/30] != 5 && gameMap[(y+29)/30][(x+30)/30] != 5) {
                x += speed;

                coinAdd();
            }
        }

        // "if" is there so you can hold two keys at once
        if (up && !down) {
            //Check if there is no wall(tile 5) to the up, and move left by the value of speed.
            if (gameMap[(y-1)/30][(x)/30] != 5 && gameMap[(y-1)/30][(x+29)/30] != 5) {
                y -= speed;

                coinAdd();
            }
        } else if (down&& !up) {
            //Check if there is no wall(tile 5) to the down, and move left by the value of speed.
            if (gameMap[(y+30)/30][(x)/30] != 5 && gameMap[(y+30)/30][(x+29)/30] != 5) {
                y += speed;

                coinAdd();
            }
        }
    }


    private void load() throws IOException {  //loads images
        InputStream is1 = getClass().getResourceAsStream("/PacMan/PM_right.png");
        InputStream is2 = getClass().getResourceAsStream("/PacMan/PM_up.png");
        InputStream is3 = getClass().getResourceAsStream("/PacMan/PM_left.png");
        InputStream is4 = getClass().getResourceAsStream("/PacMan/PM_down.png");

        PM_UP = ImageIO.read(is2);
        PM_LEFT = ImageIO.read(is3);
        PM_DOWN = ImageIO.read(is4);
        PM_RIGHT = ImageIO.read(is1);
        }


    public void setPMDirection(int direction){
        this.direction = direction;
        if (direction == 4) {
            // Set direction right and getting the right image
            try {
                PM_RIGHT = ImageIO.read(getClass().getResourceAsStream("/PacMan/PM_right.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (direction == 1) {
            // Set direction up and getting the right image
            try {
                PM_UP = ImageIO.read(getClass().getResourceAsStream("/PacMan/PM_up.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (direction == 2) {
            // Set direction left and getting the right image
            try {
                PM_LEFT = ImageIO.read(getClass().getResourceAsStream("/PacMan/PM_left.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (direction == 3) {
            // Set direction down and getting the right image
            try {
                PM_DOWN = ImageIO.read(getClass().getResourceAsStream("/PacMan/PM_down.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public int getScore() {
        return score;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setDown(boolean down) {
        this.down = down;
    }


}
