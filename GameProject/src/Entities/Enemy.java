package Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Enemy extends Entity{

    private BufferedImage G_UP, G_DOWN, G_LEFT, G_RIGHT;
    private boolean left, up, right, down;
    private int direction = 4;
    private int speed = 1;
    Player player = new Player(30,30,30,30);


    public Enemy(int x, int y, int width, int height) throws IOException {
        super(x, y, width, height);

        load();
    }

    public void update(){
        updatePosition();
        updateHitbox();
    }

    public boolean collidesWith(Player pacman) {
        return this.hitbox.intersects(pacman.getHitbox());
    }


    public void renderG(Graphics g) {  // render image in right direction

        if (direction == 1) {
            g.drawImage(G_UP, x, y, null);
        } else if (direction == 2) {
            g.drawImage(G_LEFT, x, y, null);
        } else if (direction == 3) {
            g.drawImage(G_DOWN, x, y, null);
        } else if (direction == 4) {
            g.drawImage(G_RIGHT, x, y, null);
        }

        drawHitbox(g);


    }


    public void updatePosition() {

        // "if" is there so you can hold two keys at once
        if (left && !right) {
            //Check if there is no wall(tile 5) to the left, and move left by the value of speed.
            if (player.gameMap[y/30][(x-1)/30] != 5 && player.gameMap[(y+29)/30][(x-1)/30] != 5) {
                x -= speed;
            }
        }else if (right && !left) {
            //Check if there is no wall(tile 5) to the right, and move left by the value of speed.
            if (player.gameMap[(y)/30][(x+30)/30] != 5 && player.gameMap[(y+29)/30][(x+30)/30] != 5) {
                x += speed;
            }
        }

        // "if" is there so you can hold two keys at once
        if (up && !down) {
            //Check if there is no wall(tile 5) to the up, and move left by the value of speed.
            if (player.gameMap[(y-1)/30][(x)/30] != 5 && player.gameMap[(y-1)/30][(x+29)/30] != 5) {
                y -= speed;
            }
        } else if (down&& !up) {

            //Check if there is no wall(tile 5) to the down, and move left by the value of speed.
            if (player.gameMap[(y+30)/30][(x)/30] != 5 && player.gameMap[(y+30)/30][(x+29)/30] != 5) {
                y += speed;

            }
        }


    }

    private void load() throws IOException {   //loads images
        InputStream is1 = getClass().getResourceAsStream("/Ghost/Ghost_right.png");
        InputStream is2 = getClass().getResourceAsStream("/Ghost/Ghost_up.png");
        InputStream is3 = getClass().getResourceAsStream("/Ghost/Ghost_left.png");
        InputStream is4 = getClass().getResourceAsStream("/Ghost/Ghost_down.png");

        G_UP = ImageIO.read(is2);
        G_LEFT = ImageIO.read(is3);
        G_DOWN = ImageIO.read(is4);
        G_RIGHT = ImageIO.read(is1);
    }

    public void setGDirection(int direction){
        this.direction = direction;
        if (direction == 4) {
            // Set direction right and getting the right image
            try {
                G_RIGHT = ImageIO.read(getClass().getResourceAsStream("/Ghost/Ghost_right.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (direction == 1) {
            // Set direction up and getting the right image
            try {
                G_UP = ImageIO.read(getClass().getResourceAsStream("/Ghost/Ghost_up.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (direction == 2) {
            // Set direction left and getting the right image
            try {
                G_LEFT = ImageIO.read(getClass().getResourceAsStream("/Ghost/Ghost_left.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (direction == 3) {
            // Set direction down and getting the right image
            try {
                G_DOWN = ImageIO.read(getClass().getResourceAsStream("/Ghost/Ghost_down.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
