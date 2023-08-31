package Game;

    import GameObject.*;


    import java.awt.*;
    import java.util.LinkedList;

public class Controller {
    public static LinkedList<GameObject> allObjects = new LinkedList<>();
    public static LinkedList<GameObject> toRemove = new LinkedList<>();

    public static void updateAll(){
        Player player = Player.getInstance();
        player.update();


        allObjects.forEach(obj -> player.checkCollision(obj));
        toRemove.forEach(obj -> allObjects.remove(obj));

    }
    public static void drawAll(Graphics2D g2){
        allObjects.forEach(obj -> obj.draw(g2));
        Wall.walls.forEach(wall ->  wall.draw(g2));
        drawLines(g2);//DEBUG🐞🐞🪲🐜🐛🦗🪳
    }

    //DEBUG🐞🐞🪲🐜🐛🦗🪳
    private static void drawLines(Graphics2D g2) {
        Color color = Color.PINK;
        g2.setColor(color);
        int start,end, pos;
        start=0;

        end = ScreenSettings.width;
        for (int i = 0; i < ScreenSettings.maxScreenRow; i++) {
            pos = i*ScreenSettings.tileSize;
            g2.drawLine(start,pos,end,pos);
        }

        end = ScreenSettings.height;
        for (int i = 0; i < ScreenSettings.maxScreenCol; i++) {
            pos = i*ScreenSettings.tileSize;
            g2.drawLine(pos,start,pos,end);
        }

    }

    public static void removeObj(GameObject obj){
        toRemove.add(obj);
    }

}
