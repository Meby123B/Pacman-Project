package GameObject.Entity.Ai;

import Game.ScreenSettings;
import GameObject.Entity.Ghost;
import GameObject.Entity.MoveSides;
import GameObject.Entity.Player;

public class Pinky extends Ai{
    MoveSides lastDirection = MoveSides.DOWN;
    public Pinky(Ghost ghost) {
        super(ghost);
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
            case UP ->  y -= ts*4;
            case DOWN -> y += ts*4;
            case LEFT -> x -= ts*4;
            case RIGHT -> x += ts*4;
        }

        goToX =x;
        goToY =y;

        updateTargetPosition();

    }
}