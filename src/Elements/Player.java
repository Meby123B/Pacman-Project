package Elements;

import Game.KeyHandler;

import java.awt.*;

public class Player extends Entity {

    public  Player(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update( KeyHandler keyH) {
        if (keyH.upPressed) {
            if (getUp() +  speed < 0) {return;} //לא יוצא מהקיר
            y -= speed;

        } else if (keyH.downPressed) {
            if (getDown() + speed > sc.height) {return;}
            y += speed;

        } else if (keyH.leftPressed) {
            if (getLeft() + speed < 0) {return;} //לא יוצא מהקיר
            x -= speed;

        } else if (keyH.rightPressed) {
            if (getRight() + speed > sc.width) {return;}
            x += speed;
        }
    }
    public int getLeft(){ return x;}
    public int getRight(){ return x+sc.tileSize;}
    public int getUp(){ return y;}
    public int getDown(){ return y+ sc.tileSize;}

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(x,y,sc.tileSize,sc.tileSize);
//        System.out.println("x:"+x+"|y:"+y);
    }
    public boolean checkCollision(Dot dot){
        return getUp() <= dot.getDown()
                && getDown() >= dot.getUp()
                && getLeft() <= dot.getRight()
                && getRight() >= dot.getLeft();//TODO
    }
}
