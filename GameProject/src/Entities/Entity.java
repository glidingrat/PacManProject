package Entities;


import java.awt.*;

public abstract class Entity {

    protected int x,y,width,height;
    protected Rectangle hitbox;

    public Entity(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        createHitbox();
    }

    public void drawHitbox(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Set transparent hitbox
        float transparency = 0f;
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
        g2d.setComposite(alphaComposite);


        g2d.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
        g2d.dispose();
    }

    private void createHitbox() {
        hitbox = new Rectangle(x,y,width,height);
    }

    protected void updateHitbox(){
        hitbox.setLocation(x,y);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }


    // for UNIT tests ↓
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
