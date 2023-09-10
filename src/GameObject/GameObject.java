package GameObject;

import Game.ScreenSettings;
import GameObject.Environment.Environment;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;

import java.awt.*;

import static Game.ScreenSettings.tileSize;

public abstract class GameObject {
    protected int x,y;
    protected int width = tileSize;
    protected int height = tileSize;
    protected Color color = Color.GRAY;
    private int originalX , originalY;

    public GameObject(int x, int y, Color color){
        this.x = x ;
        this.y = y ;
        this.color = color;
    }

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
    public void setColor(Color newColor){ color = newColor;}
    public Color getColor(){return color;}
    public  void collideWithPlayer(Player p){};
    public  void collideWithGhost(Ghost g){};


    public void update() {
    }

    public void resetPosition() {
        this.x = originalX;
        this.y = originalY;
    }

    protected void setOriginalPos(int x, int y) {
        this.originalX = x;
        this.originalY = y;
    }
}
