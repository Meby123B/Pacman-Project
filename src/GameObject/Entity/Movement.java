package GameObject.Entity;


import Game.Collision;
import Game.ScreenSettings;
import GameObject.GameObject;
import GameObject.Movable;

public class Movement {
    static int objSpeed;
    static MoveSides lastDirection;

    public static void moveObject(GameObject obj, MoveSides dir){
        if (dir == null) return;

        extractSpeedAndDir(obj);
        moveIt(obj,dir);

        if (Collision.checkCollisionWithWall(obj)){
            cancelMove(obj,dir);
            resetDirection(obj);
        }
    }
    public static void moveThroughWall(GameObject obj, MoveSides dir){
        if (dir == null) return;

        extractSpeedAndDir(obj);
        moveIt(obj,dir);
    }
    public static void changeDirection(GameObject obj, MoveSides dir){
        if (dir == null) return;

        extractSpeedAndDir(obj);
        setDirection(obj,dir);

        moveIt(obj,dir);
        if (Collision.checkCollisionWithWall(obj)){
            resetDirection(obj);
        }
        cancelMove(obj,dir);
    }
    public static boolean checkDirection(GameObject obj, MoveSides dir){
        if (dir == null) return false;
        boolean result = true;

        extractSpeedAndDir(obj);

        moveIt(obj,dir);
        if (Collision.checkCollisionWithWall(obj)){
            result = false;
        }
        cancelMove(obj,dir);
        return result;
    }

    private static void extractSpeedAndDir(GameObject obj){
        objSpeed = (int)(((Movable)obj).getSpeed()* ScreenSettings.scale);
        lastDirection = ((Movable)obj).getDirection();
    }

    private static void moveIt(GameObject obj, MoveSides dir) {
        switch (dir){
            case UP -> moveUp(obj);
            case DOWN -> moveDown(obj);
            case LEFT -> moveLeft(obj);
            case RIGHT -> moveRight(obj);
        }
    }
    private static void cancelMove(GameObject obj, MoveSides dir) {
        switch (dir){
            case UP -> moveDown(obj);
            case DOWN -> moveUp(obj);
            case LEFT -> moveRight(obj);
            case RIGHT -> moveLeft(obj);
        }
    }

    private static void moveUp(GameObject obj){
        obj.setY(obj.getY() - objSpeed);
    }
    private static void moveDown(GameObject obj){
        obj.setY(obj.getY() + objSpeed);
    }
    private static void moveLeft(GameObject obj){
        obj.setX(obj.getX() - objSpeed);
    }
    private static void moveRight(GameObject obj) {
        obj.setX(obj.getX() + objSpeed);
    }

    private static void resetDirection(GameObject obj){
        Movable mObj = (Movable)obj;
        if (mObj.getDirection() == lastDirection){
           lastDirection = null;
        }
        mObj.setDirection(lastDirection);
    }
    private static void setDirection(GameObject obj, MoveSides newDirection){
        ((Movable)obj).setDirection(newDirection);
    }
}
