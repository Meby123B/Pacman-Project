package GameObject.Entity.Ai;


import Game.Collision;
import Game.ScreenSettings;
import GameObject.Entity.Ghost;
import GameObject.Entity.MoveSides;
import GameObject.Entity.Movement;
import GameObject.TargetSign;

import java.util.Random;

public abstract class Ai  {
    int goToX, goToY;
    double line=100000.0;
    boolean up,down,left,right;
    protected Ghost ghost;
    protected TargetSign target;

    public Ai(Ghost ghost){
        this.ghost=ghost;
    }
    protected void setTarget(){
        this.target = new TargetSign(0,0, ghost.getColor());
    }
    protected void updateTargetPosition(){
        target.setX(goToX);
        target.setY(goToY);
    }

    protected MoveSides getRandomDir(Ghost ghost) {
        if (ghost.getDirection() != null) {
            return ghost.getDirection();
        }

        Random rand = new Random();

        return switch (rand.nextInt(4)) {
            case 0 -> MoveSides.LEFT;
            case 1 -> MoveSides.DOWN;
            case 2 -> MoveSides.UP;
            case 3 -> MoveSides.RIGHT;
            default -> null;
        };

    }

    protected abstract void setGoTo();

    public MoveSides getDirection(Ghost ghost){
        MoveSides newDirection = null;

        setGoTo();
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

    private MoveSides compareDistances(Ghost ghost, MoveSides originalDir, MoveSides newDir) {
        double lineTemp = calculateDistance(ghost, newDir);
        if (lineTemp < line){
            line = lineTemp;
            return newDir;
        }
        return originalDir;
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
