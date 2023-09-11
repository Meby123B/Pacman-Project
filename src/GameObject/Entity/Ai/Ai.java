package GameObject.Entity.Ai;


import Game.Collision;
import Game.ScreenSettings;
import GameObject.Entity.Ghost;
import GameObject.Entity.MoveSides;
import GameObject.Entity.Movement;
import GameObject.Entity.Player;

import java.util.Random;

public abstract class Ai {
    int goToX, goToY;
    double line=100000.0;
    boolean up,down,left,right;
    protected Ghost ghost;

    public Ai(Ghost ghost){
        this.ghost=ghost;
    }

    public MoveSides getRandomDir(Ghost ghost) {
        setGhost(ghost); //todo remove after make ai not
        if (ghost.getDirection() == null) {
            return ghost.getDirection();
        }

        MoveSides newDir = null;

        Random rand = new Random();
        switch (rand.nextInt(4)) {
            case 0 -> newDir = MoveSides.LEFT;
            case 1 -> newDir = MoveSides.DOWN;
            case 2 -> newDir = MoveSides.UP;
            case 3 -> newDir = MoveSides.RIGHT;
        }

        return newDir;
    }

    public abstract void setGoTo();


    public MoveSides getDirection(Ghost ghost){
        MoveSides newDirection = null;

        setGoTo();
//        setGhost(ghost); //todo remove after make ai not
        checkAvailableDirections();
        newDirection = getPriority(newDirection);

        return newDirection;

    }

    private void setGhost(Ghost g) {
        ghost = g;
    }

    private MoveSides getPriority(MoveSides newDirection) {
        if (up) {
            newDirection = compareDistances(ghost, newDirection,  MoveSides.UP);}
        if (left) {
            newDirection = compareDistances(ghost, newDirection,  MoveSides.LEFT);}
        if (down) {
            newDirection = compareDistances(ghost, newDirection,  MoveSides.DOWN);}
        if (right) {
            newDirection = compareDistances(ghost, newDirection,  MoveSides.RIGHT);}

        line =10000.0;
        return newDirection;
    }

    private void checkAvailableDirections() {
        MoveSides lastDir = ghost.getDirection();

        up = Movement.checkDirection(ghost, MoveSides.UP);
        down = Movement.checkDirection(ghost, MoveSides.DOWN);
        left = Movement.checkDirection(ghost, MoveSides.LEFT);
        right = Movement.checkDirection(ghost, MoveSides.RIGHT);

        if (lastDir == null) return;

        switch (lastDir){
            case UP ->  down=false;
            case DOWN -> up=false;
            case LEFT -> right=false;
            case RIGHT -> left=false;
        }

    }
    private boolean checkDir(Ghost ghost, MoveSides dir){
        int x = ghost.getX();
        int y = ghost.getY();

        int ts = ScreenSettings.tileSize;
        switch (dir){
            case UP ->  y -= ghost.getSpeed();
            case DOWN -> y += ghost.getSpeed();
            case LEFT -> x -= ghost.getSpeed();
            case RIGHT -> x += ghost.getSpeed();
        }
        return !(Collision.isCollideWithWall(y, x, x + ts, y + ts));
    }

    private MoveSides compareDistances(Ghost ghost, MoveSides originalDir, MoveSides newDir) {
        double lineTemp = calculateDistance(ghost, newDir);
        if (lineTemp < line){
            line = lineTemp;
            return newDir;
        }
        return originalDir;
    }

    private int numOfOptions() {
        int num =0;
        if (up) num++;
        if (down) num++;
        if (left) num++;
        if (right) num++;
        return num;
    }

    public double calculateDistance(Ghost ghost, MoveSides dir){
        int x = ghost.getX();
        int y = ghost.getY();
        //move one step
        int ts = ScreenSettings.tileSize;
        switch (dir){
            case UP ->  y -= ts;
            case DOWN -> y += ts;
            case LEFT -> x -= ts;
            case RIGHT -> x += ts;
        }
        // calculate distance
        int w = Math.abs(goToX - x); //todo change it to gotoX
        int h = Math.abs(goToY - y);
        return Math.sqrt((w*w) + (h*h));
    }
}
