package GameObject;

public class Movement {
    static int objSpeed;
    static MoveSides lastDirection;

    public static void moveObject(GameObject obj, MoveSides dir){
        if (dir == null) return;

        extractSpeedAndDir(obj);
        moveIt(obj,dir);

        if (checkWallCollision(obj)){
            cancelMove(obj,dir);
        }
    }
    public static void changeDirection(GameObject obj, MoveSides dir){
        if (dir == null) return;

        extractSpeedAndDir(obj);
        setDirection(obj,dir);

        moveIt(obj,dir);
        if (checkWallCollision(obj)){
            resetDirection(obj);
        }
            cancelMove(obj,dir);
    }

    private static void extractSpeedAndDir(GameObject obj){
        objSpeed = ((Movable)obj).getSpeed();
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


    public static boolean checkWallCollision(GameObject o){ //Todo move it!
        for (int i = 0; i < Wall.walls.size(); i++) {

            if(o.checkCollision(Wall.walls.get(i))){
                return true;
            }
        }
        return false;
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
        ((Movable)obj).setDirection(lastDirection);
    }
    private static void setDirection(GameObject obj, MoveSides newDirection){
        ((Movable)obj).setDirection(newDirection);
    }
}
