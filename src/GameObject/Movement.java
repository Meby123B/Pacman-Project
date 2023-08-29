package GameObject;

import Game.ScreenSettings;

public class Movement {
    static int objSpeed;

    public static void moveObject(GameObject obj, MoveSides dir){
        extractSpeed(obj);
        switch (dir){
            case UP -> moveUp(obj);
            case DOWN -> moveDown(obj);
            case LEFT -> moveLeft(obj);
            case RIGHT -> moveRight(obj);
        }
    }
    private static void extractSpeed(GameObject obj){
        objSpeed = ((Movable)obj).getSpeed();
    }

    private static boolean check(GameObject o, MoveSides dir){
        for (int i = 0; i < Wall.walls.size(); i++) {
            if(o.checkCollision(Wall.walls.get(i))){
                return false;
            }
        }

        switch (dir){
            case UP -> {return o.getUp() - objSpeed > 0;}
            case DOWN ->{return o.getDown() + objSpeed < ScreenSettings.height;}
            case LEFT -> {return o.getLeft() - objSpeed > 0;}
            case RIGHT -> {return o.getRight() + objSpeed < ScreenSettings.width;}
        }
        return false;
    }

    private static void moveUp(GameObject obj){
        if (check(obj,MoveSides.UP)){
            obj.setY(obj.getY() - objSpeed);
        }
    }
    private static void moveDown(GameObject obj){
        if (check(obj,MoveSides.DOWN)) {
            obj.setY(obj.getY() + objSpeed);
        }
    }
    private static void moveLeft(GameObject obj){
        if (check(obj,MoveSides.LEFT)) {
            obj.setX(obj.getX() - objSpeed);
        }
    }
    private static void moveRight(GameObject obj) {
        if (check(obj, MoveSides.RIGHT)) {
            obj.setX(obj.getX() + objSpeed);
        }
    }
}
