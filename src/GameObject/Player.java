package GameObject;

import Game.KeyHandler;
import Game.ScreenSettings;

import java.awt.*;

public class Player extends GameObject implements Movable {
    int speed = 4;

    public  Player(){
        x = 100;
        y = 100;
        color = Color.ORANGE;
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
