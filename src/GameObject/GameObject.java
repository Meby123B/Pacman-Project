package GameObject;

import Game.ScreenSettings;

import java.awt.*;

public abstract class GameObject {
    int tileSize = ScreenSettings.tileSize;
    int x,y;
    Color color;

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x,y,tileSize,tileSize);
    }
    public int getLeft(){ return x;}
    public int getRight(){ return x+tileSize;}
    public int getUp(){ return y;}
    public int getDown(){ return y+ tileSize;}

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



    public void checkCollision(GameObject other){
        if (getUp() <= other.getDown()
                && getDown() >= other.getUp()
                && getLeft() <= other.getRight()
                && getRight() >= other.getLeft()
        ){
            other.playerCollide();
        }
    }


}
