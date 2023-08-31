package GameObject;

import Game.KeyHandler;

import java.awt.*;

public class Player extends GameObject implements Movable {
    int speed = 4;
    static Player instance;
    public static Player getInstance(){

        if (instance == null){
            Player p = new Player();
            p.x = 100;
            p.y = 100;
            p.color = Color.ORANGE;


            instance = p;
            return p;
        }
        return instance;
    }


    public void moveByKeys() {
        if (KeyHandler.upPressed) {
            move(MoveSides.UP);
        } else if (KeyHandler.downPressed) {
            move(MoveSides.DOWN);
        } else if (KeyHandler.leftPressed) {
            move(MoveSides.LEFT);
        } else if (KeyHandler.rightPressed) {
            move(MoveSides.RIGHT);
        }
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void move(MoveSides dir) {
        Movement.moveObject(this, dir);
//        System.out.println("x:"+x+" y:"+y);
    }

    @Override
    public void playerCollide() {    }
}
