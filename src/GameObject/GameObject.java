package GameObject;

import java.awt.*;

import static Game.ScreenSettings.tileSize;

public abstract class GameObject {
    int x,y;
    int width = tileSize;
    int height = tileSize;
    Color color;

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
    public abstract void playerCollide();



    public boolean checkCollision(GameObject other){
        if (getUp() <= other.getDown()
                && getDown() >= other.getUp()
                && getLeft() <= other.getRight()
                && getRight()-2 >= other.getLeft()
        ){
            other.playerCollide();
            return true;
        }
        return false;
    }


}
