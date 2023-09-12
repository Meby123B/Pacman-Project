package GameObject.Entity.Ai;

import Game.ScreenSettings;
import GameObject.Entity.Entity;
import GameObject.Entity.Ghost;
import GameObject.Entity.MoveSides;
import GameObject.Entity.Player;

import java.awt.*;

public class Inky extends Ai{
    private Ghost blinky;
    private MoveSides lastDirection = MoveSides.DOWN;

    public Inky(Ghost ghost) {
        super(ghost);
        saveBlinkyGhost();
        setTarget();
    }

    @Override
    public void setGoTo() {
        int x = Player.getInstance().getX();
        int y = Player.getInstance().getY();

        MoveSides dir = Player.getInstance().getDirection();

        if (dir == null) {dir = lastDirection;}
        lastDirection = dir;
        int ts = ScreenSettings.tileSize;
        switch (dir){
            case UP ->  y -= ts*2;
            case DOWN -> y += ts*2;
            case LEFT -> x -= ts*2;
            case RIGHT -> x += ts*2;
        }

        x += x-blinky.getX();
        y += y-blinky.getY();


        goToX = x;
        goToY = y;
        updateTargetPosition();

    }

    private void saveBlinkyGhost() {
        Entity.list.forEach(ent ->{
            if (ent.getColor() == Color.red){
                blinky = (Ghost) ent;
            }
        });
    }
}
