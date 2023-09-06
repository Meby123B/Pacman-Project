package GameObject.Entity;

import Game.Controller;
import Game.KeyHandler;
import Game.Manager.Life;
import Game.ScreenSettings;
import GameObject.Eatable;
import GameObject.Movable;
import GameObject.GameObject;

import java.awt.*;

public class Player extends GameObject implements Movable, Eatable {
    int speed = 2;
    MoveSides direction=null;
    int life;

    static Player instance;
    public static Player getInstance(){

        if (instance == null){
            Player p = new Player();
            p.life = 3;
            System.out.println("life: " + p.life );
            p.y = 23*ScreenSettings.tileSize;
            p.x = 13*ScreenSettings.tileSize + ScreenSettings.tileSize/2;
            p.color = Color.YELLOW;

            p.setOriginalPos(p.x,p.y);

            Entity.list.add(p);
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
    @Override
    public void update() {
        if (life <=0) {return;}
//        System.out.println(direction); //D🪲
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
//        System.out.println("x:"+x+" y:"+y); //D🪲
    }

    @Override
    public void changeDirection(MoveSides dir) {
        Movement.changeDirection(this, dir);
    }

        @Override
    public MoveSides getDirection() {
        return direction;
    }
    @Override
    public void setDirection(MoveSides dir) {
        this.direction = dir;
    }

    private void loseLife(){
        Life.lose();
        resetPosition();
        if (Life.getLife() <= 0){gameover();}
    }
    private void gameover(){
        Controller.removeObj(this);
        System.out.println("GAME OVER!");
    }

    @Override
    public void whenEaten() {
        loseLife();
    }
    @Override
    public void collideWithGhost(Ghost g) {}

}
