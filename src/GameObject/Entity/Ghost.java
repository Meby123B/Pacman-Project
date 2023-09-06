package GameObject.Entity;

import Game.Controller;
import GameObject.Eatable;
import GameObject.Movable;
//import GameObject.*;

import java.awt.*;

public class Ghost extends GameObject.GameObject implements Movable, Eatable {
    int speed = 2;
    MoveSides direction=null;
    public Ghost(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;

        Entity.list.add(this);
    }
    @Override
    public void update() {
//        System.out.println("g:dir " + direction); //D🪲
        if (direction == null){
            direction = Ai.getDirection();
        }
        move(direction);

    }
    public void collideWithPlayer(Player p){
        p.whenEaten();
        this.whenEaten();
    }

    @Override
    public void move(MoveSides dir) {
        Movement.moveObject(this,dir);
    }

    @Override
    public void changeDirection(MoveSides dir) {}

    @Override
    public int getSpeed() {
        return speed;
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
        Controller.removeObj(this);
    }
}
