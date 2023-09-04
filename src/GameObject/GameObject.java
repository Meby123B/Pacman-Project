package GameObject;

import java.awt.*;

import static Game.ScreenSettings.tileSize;

public abstract class GameObject {
    protected int x,y;
    int width = tileSize;
    int height = tileSize;
    Color color = Color.GRAY;

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x,y,width,height);
    }
    public int getLeft(){ return x;}
    public int getRight(){ return x+width-1;}
    public int getUp(){ return y;}
    public int getDown(){ return y+ height-1;}

    public int getX() {
        return x;
    }
    public void setX(int newX) {
        x = newX;
    }
    public int getY() {
        return y;
    }
    public void setY(int newY) {
        this.y = newY;
    }
    public void getColor(Color newColor){ color = newColor;}
    public Color getColor(){return color;}
    public abstract void collideWithPlayer(Player p);
    public abstract void collideWithGhost(Ghost g);



    public boolean checkCollision(GameObject other){
        if (
            getUp() <= other.getDown()
            && getDown() >= other.getUp()
            && getLeft() <= other.getRight()
            && getRight() >= other.getLeft()
        ){
            other.collideWithPlayer(Player.getInstance());
            return true;
        }
        return false;
    }


}
