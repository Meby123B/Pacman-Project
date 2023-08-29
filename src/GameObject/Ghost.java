package GameObject;

import Game.Controller;

import java.awt.*;

public class Ghost extends GameObject implements  Movable{

    public Ghost(){
        x =200;
        y =200;
        color = Color.blue;
    }
    public void playerCollide(){

    }

    @Override
    public void move(MoveSides dir) {
        Movement.moveObject(this,dir);
    }

    @Override
    public int getSpeed() {
        return 4;
    }
}
