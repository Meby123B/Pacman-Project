package GameObject;

import Game.KeyHandler;

import java.awt.*;

public class Player extends GameObject implements Movable {

    public  Player(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update( KeyHandler keyH) {
        if (keyH.upPressed) {
            move(MoveSides.UP);

        } else if (keyH.downPressed) {
            move(MoveSides.DOWN);

        } else if (keyH.leftPressed) {
            move(MoveSides.LEFT);

        } else if (keyH.rightPressed) {
            move(MoveSides.RIGHT);

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

    @Override
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
        this.y = newY;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public boolean checkCollision(Dot dot){
        return getUp() <= dot.getDown()
                && getDown() >= dot.getUp()
                && getLeft() <= dot.getRight()
                && getRight() >= dot.getLeft();
    }



    @Override
    public void move(MoveSides dir) {
        Movement.moveObject(this, dir);
    }
}
