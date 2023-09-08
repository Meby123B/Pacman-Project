package GameObject.Entity;

import Game.Controller;
import Game.Manager.GameManager;
import Game.Manager.Timer;
import Game.ScreenSettings;
import GameObject.Eatable;
import GameObject.Movable;
//import GameObject.*;

import java.awt.*;

public class Ghost extends GameObject.GameObject implements Movable, Eatable {
    int speed = 2;
    boolean getOut= true;
    Ai ai;
    MoveSides direction=null;
    public Ghost(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;

        super.setOriginalPos(x,y);

        Entity.list.add(this);
    }
    public Ghost(int x, int y, Color color, Ai ai){//todo
        this.ai = ai;
        this.x = x;
        this.y = y;
        this.color = color;

        super.setOriginalPos(x,y);

        Entity.list.add(this);
    }
    @Override
    public void update() {
//        System.out.println("g:dir " + direction); //D🪲
        if (direction == null){
            direction = GameManager.gameMode.
                    getGhostAi(this).getDirection(); //todo AI make it interface
        }
        if (getOut){
            exit();
        }
        move(direction);
    }
    public void collideWithPlayer(Player p){
        GameManager.gameMode
                .whenGhostEaten(this).whenEaten();
    }

    @Override
    public void move(MoveSides dir) {
        Movement.moveObject(this,dir);
    }

    @Override
    public void changeDirection(MoveSides dir) {}

    @Override
    public int getSpeed() {
        return GameManager.gameMode
                .ghostSpeed();
    }

    @Override
    public MoveSides getDirection() {
        return direction;
    }

    @Override
    public void setDirection(MoveSides dir) {
        this.direction = dir;
    }

    @Override
    public void whenEaten() {
        setDirection(null);
        this.resetPosition();
    }

    public void exit() {
        if (y <= ScreenSettings.tileSize *11) {
            getOut = false;
            return;
        }

        Movement.moveThroughWall(this, MoveSides.UP);
    }

    public void setOut() {
        this.getOut = true;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(GameManager.gameMode
                .getGhostColor(this));
        g2.fillRect(x,y,width,height);
    }

    public Ai getAi() {
        return this.ai;
    }
}