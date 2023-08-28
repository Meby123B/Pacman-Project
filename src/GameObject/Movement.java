package GameObject;


import Game.ScreenSettings;

public class Movement {
    static ScreenSettings sc = new ScreenSettings();
    public static void moveObject(GameObject obj, MoveSides dir){
        switch (dir){
            case UP -> moveUp(obj);
            case DOWN -> moveDown(obj);
            case LEFT -> moveLeft(obj);
            case RIGHT -> moveRight(obj);
        }
    }

    public static boolean check(GameObject o, MoveSides dir){
        switch (dir){
            case UP -> {return o.getUp() + o.getSpeed() > 0;}
            case DOWN ->{return o.getDown() + o.getSpeed() < sc.height;}
            case LEFT -> {return o.getLeft() + o.getSpeed() > 0;}
            case RIGHT -> {return o.getUp() + o.getSpeed() < sc.width;}
        }
        return false;
    }

    private static void moveUp(GameObject obj){
        if (check(obj,MoveSides.UP)){
            obj.setY(obj.getY() - obj.getSpeed());
        }
    }
    private static void moveDown(GameObject obj){

        if (check(obj,MoveSides.DOWN)) {
            System.out.println(check(obj,MoveSides.DOWN));
            obj.setY(obj.getY() + obj.getSpeed());
        }
    }
    private static void moveLeft(GameObject obj){
        if (check(obj,MoveSides.LEFT)) {
            obj.setX(obj.getX() - obj.getSpeed());
        }
    }
    private static void moveRight(GameObject obj) {
        if (check(obj, MoveSides.RIGHT)) {
            obj.setX(obj.getX() + obj.getSpeed());
        }
    }
}
