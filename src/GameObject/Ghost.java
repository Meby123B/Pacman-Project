package GameObject;

import Game.Controller;

import java.awt.*;

public class Ghost extends GameObject implements  Movable, Eatable{
    int speed = 3;
    MoveSides direction=null;
    public Ghost(int x, int y){
        this.x = x;
        this.y = y;
        color = Color.red;
    }
    public void playerCollide(Player p){
        p.whenEaten();
        this.whenEaten();
    }

    @Override
    public void move(MoveSides dir) {
        Movement.moveObject(this,dir);
    }

    @Override
    public void changeDirection(MoveSides dir) {

    }

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
