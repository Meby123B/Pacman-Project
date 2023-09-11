package GameObject.Entity;

import Game.Controller;
import Game.KeyHandler;
import Game.Manager.GameManager;
import Game.Manager.Life;
import Game.ScreenSettings;
import GameObject.Eatable;
import GameObject.Movable;
import GameObject.GameObject;

import java.awt.*;

public class Player extends GameObject implements Movable, Eatable {
    int speed = 2;
    MoveSides direction=null;
    static Player instance;

    private Player(int x, int y, Color color) {
        super(x, y, color);
    }

    public static Player getInstance(){

        if (instance == null){
            int x = 13*ScreenSettings.tileSize + ScreenSettings.tileSize/2;
            int y = 23*ScreenSettings.tileSize;
            Player p = new Player(x,y,Color.YELLOW);

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
        if (Life.getLife() <=0) {return;}
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
        Controller.resetEntities();
        if (Life.getLife() <= 0){gameover();}
    }
    private void gameover(){
        Controller.removeObj(this);
        System.out.println("GAME OVER!");
    }

    @Override
    public void whenEaten() {
        setDirection(null);
        loseLife();
    }
    @Override
    public void collideWithGhost(Ghost g) {}

}
