package Elements;

import java.awt.*;

public class Dot extends Collectable{
    static int score = 0;
    public Dot(){
        x =50;
        y =50;
        value = 100;
    }
    public void playerColide(){
        score += value;
        System.out.println(score);
    }
    public int getLeft(){ return x;}
    public int getRight(){ return x+sc.tileSize;}
    public int getUp(){ return y;}
    public int getDown(){ return y+ sc.tileSize;}

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.green);
        g2.fillRect(x,y,sc.tileSize,sc.tileSize);
    }

    public int getX() {
        return x;
    }

    @Override
    public void setX(int newX) {
        x = newX;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int newY) {
        y = newY;
    }

    @Override
    public int getSpeed() {
        return 0;
    }


}
