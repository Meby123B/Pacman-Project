package GameObject.Entity;


import Game.Collision;
import Game.ScreenSettings;

import java.util.Random;

public class Ai {
    int goToX, goToY;
    static double line=100000.0;
    static boolean up,down,left,right;
    public static MoveSides getDirection() {
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

    public  MoveSides goTo(int x, int y) {
        return null;
    }
    public static MoveSides priority(Ghost ghost){
        checkAvailableDirections(ghost);

        MoveSides dirResult=null;
        if (up) {
            dirResult = compareDistances(ghost,dirResult,  MoveSides.UP);}
        if (left) {
            dirResult = compareDistances(ghost,dirResult,  MoveSides.LEFT);}
        if (down) {
            dirResult = compareDistances(ghost,dirResult,  MoveSides.DOWN);}
        if (right) {
            dirResult = compareDistances(ghost,dirResult,  MoveSides.RIGHT);}

        System.out.println("finish: "+ dirResult);
        line =10000.0;
        return dirResult;

    }

    private static void checkAvailableDirections(Ghost ghost) {
        MoveSides lastDir = ghost.getDirection();

        up = checkDir(ghost, MoveSides.UP);
        System.out.println("up: "+up);
        down = checkDir(ghost, MoveSides.DOWN);
        System.out.println("down: "+down);
        left = checkDir(ghost, MoveSides.LEFT);
        System.out.println("left: "+left);
        right = checkDir(ghost, MoveSides.RIGHT);
        System.out.println("right: "+right);

        if (lastDir == null) return;

        switch (lastDir){
            case UP ->  down=false;
            case DOWN -> up=false;
            case LEFT -> right=false;
            case RIGHT -> left=false;
        }
    }
    private static boolean checkDir(Ghost ghost, MoveSides dir){
        int x = ghost.getX(); //todo change it to gotoX
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

    private static MoveSides compareDistances(Ghost ghost, MoveSides originalDir, MoveSides newDir) {
        double lineTemp = calculateDistance(ghost, newDir);
        if (lineTemp < line){
            line = lineTemp;
            return newDir;
        }
        return originalDir;
    }

    private static int numOfOptions() {
        int num =0;
        if (up) num++;
        if (down) num++;
        if (left) num++;
        if (right) num++;
        return num;
    }

    public static double calculateDistance(Ghost ghost, MoveSides dir){
        int x = ghost.getX(); //todo change it to gotoX
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
        int w = Math.abs(Player.getInstance().getX() - x);
        int h = Math.abs(Player.getInstance().getY() - y);
        return Math.sqrt((w*w) + (h*h));
    }
}
