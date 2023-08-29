package GameObject;

import Game.Controller;

import java.awt.*;

public class Dot extends GameObject implements Collectable, Movable{
    static int score = 0;
    int value;
    public Dot(){
        x =50;
        y =50;
        color = Color.green;
        value = 100;
    }
    public void playerCollide(){
        score += value;
        System.out.println(score);
        Controller.allObjects.remove(this);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void move(MoveSides dir) {
        Movement.moveObject(this,dir);
    }

    @Override
    public int getSpeed() {
        return 1;
    }
}
