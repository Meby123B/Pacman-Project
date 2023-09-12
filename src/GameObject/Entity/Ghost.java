package GameObject.Entity;

import Game.Manager.GameManager;
import Game.ScreenSettings;
import GameObject.Eatable;
import GameObject.Entity.Ai.Ai;
import GameObject.Movable;
//import GameObject.*;

import java.awt.*;

public class Ghost extends GameObject.GameObject implements Movable, Eatable {
    boolean getOut= true;
    Ai ai;
    MoveSides direction=null;

    public Ghost(int x, int y, Color color){

        super(x,y,color);
        super.setOriginalPos(x,y);
        Entity.list.add(this);
    }

    public void setAi(Ai ai) {
        this.ai = ai;
    }

    @Override
    public void update() {
        direction = GameManager.getGameMode().getGhostAi(this).getDirection(this);

//        System.out.println("g:dir " + direction); //D🪲
//        if (direction == null){
//            direction = GameManager.getGameMode().
//                    getGhostAi(this).getRandomDir(); //todo AI make it interface
//        }
        if (getOut){
            exit();
        }
        move(direction);
    }
    public void collideWithPlayer(Player p){
        GameManager.getGameMode()
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
        return GameManager.getGameMode()
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
        getOut=true;
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
        g2.setColor(GameManager.getGameMode()
                .getGhostColor(this));
        g2.fillRect(x,y,width,height);
    }

    public Ai getAi() {
        return this.ai;
    }
}
