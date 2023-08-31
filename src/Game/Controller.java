package Game;

    import GameObject.*;


    import java.awt.*;
    import java.util.LinkedList;

public class Controller {
    public static LinkedList<GameObject> allObjects = new LinkedList<>();
//    public static GameObject[] all = new GameObject[5];
    public static LinkedList<GameObject> toRemove = new LinkedList<>();
    public static void updateAll(){
        Player player = Player.getInstance();
        player.moveByKeys();

        allObjects.forEach(obj -> player.checkCollision(obj));
        toRemove.forEach(obj -> allObjects.remove(obj));

    }
    public static void drawAll(Graphics2D g2){
        allObjects.forEach(obj -> obj.draw(g2));
        Wall.walls.forEach(wall ->  wall.draw(g2));
    }
    public static void removeObj(GameObject obj){
        toRemove.add(obj);
    }

}
