package GameObject;

import Game.Controller;

import java.awt.*;

public class Ghost extends GameObject implements  Movable{
    MoveSides direction=null;
    public Ghost(){
        x =400;
        y =200;
        color = Color.red;
    }
    public void playerCollide(){

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
        return 4;
    }

    @Override
    public MoveSides getDirection() {
        return direction;
    }

    @Override
    public void setDirection(MoveSides dir) {
        this.direction = dir;
    }
}
