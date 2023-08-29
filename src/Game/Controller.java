package Game;

    import GameObject.*;


    import java.awt.*;
    import java.util.LinkedList;

public class Controller {
    public static LinkedList<GameObject> allObjects= new LinkedList<>();
//    public static GameObject[] all = new GameObject[5];
    public static void updateAll(Player player){
        allObjects.forEach(obj ->{
            if (obj != null){
                player.checkCollision(obj);
            }
        });
    }
    public static void drawAll(Graphics2D g2){
        allObjects.forEach(obj ->{
            if (obj != null){
                obj.draw(g2);
            }
        });
        Wall.walls.forEach(wall -> {
            wall.draw(g2);
        });
    }
    public static void removeObj(GameObject obj){
        int i = Controller.allObjects.indexOf(obj);
        Controller.allObjects.set(i, null);
    }

}
