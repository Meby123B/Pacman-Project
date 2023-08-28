package Elements;


public class Movment {
    public static void movement(Element el, MoveSides dir){
        switch (dir){
            case UP -> moveUp(el);
            case DOWN -> moveDown(el);
            case LEFT -> moveLeft(el);
            case RIGHT -> moveRight(el);
        }
    }

    private static void moveUp(Element el){
        el.setY(el.getY() - el.getSpeed());
    }
    private static void moveDown(Element el){
        el.setY(el.getY() + el.getSpeed());
    }
    private static void moveLeft(Element el){
        el.setX(el.getX() - el.getSpeed());
    }
    private static void moveRight(Element el){
        el.setX(el.getX() + el.getSpeed());
    }
}
