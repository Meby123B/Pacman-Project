package GameObject;

import Game.KeyHandler;
import Game.ScreenSettings;

import java.awt.*;

public class Player extends GameObject implements Movable {
    int speed = 4;
    MoveSides direction=null;

    static Player instance;
    public static Player getInstance(){

        if (instance == null){
            Player p = new Player();
            p.y = 2*ScreenSettings.tileSize;
            p.x = 12*ScreenSettings.tileSize;
            p.color = Color.ORANGE;

            instance = p;
            return p;
        }
        return instance;
    }
    public void checkKeys() {
        if (KeyHandler.upPressed) {
            changeDirection(MoveSides.UP);

        } else if (KeyHandler.downPressed) {
            changeDirection(MoveSides.DOWN);

        } else if (KeyHandler.leftPressed) {
            changeDirection(MoveSides.LEFT);

        } else if (KeyHandler.rightPressed) {
            changeDirection(MoveSides.RIGHT);
        }
    }
    public void update() {
//        System.out.println(direction);
        checkKeys();
        move(direction);
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void move(MoveSides dir) {
        Movement.moveObject(this, dir);
        System.out.println("x:"+x+" y:"+y);
    }

    @Override
    public void changeDirection(MoveSides dir) {
        Movement.changeDirection(this, dir);
    }

    @Override
    public void playerCollide() {    }
        @Override
    public MoveSides getDirection() {
        return direction;
    }
    @Override
    public void setDirection(MoveSides dir) {
        this.direction = dir;
    }
}
