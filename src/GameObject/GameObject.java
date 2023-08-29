package GameObject;

import Game.ScreenSettings;

import java.awt.*;

public abstract class GameObject {
    int x,y;
    Color color;

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x,y,ScreenSettings.tileSize,ScreenSettings.tileSize);
    }
    public int getLeft(){ return x;}
    public int getRight(){ return x+ScreenSettings.tileSize;}
    public int getUp(){ return y;}
    public int getDown(){ return y+ ScreenSettings.tileSize;}

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


    public boolean checkCollision(Dot dot){
        return getUp() <= dot.getDown()
                && getDown() >= dot.getUp()
                && getLeft() <= dot.getRight()
                && getRight() >= dot.getLeft();
    }


}
