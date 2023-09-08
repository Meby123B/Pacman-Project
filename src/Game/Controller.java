package Game;

    import Game.Manager.Life;
    import Game.Manager.Score;
    import Game.Manager.Timer;
    import GameObject.*;
    import GameObject.Entity.Entity;
    import GameObject.Entity.Ghost;
    import GameObject.Environment.Environment;
    import GameObject.Entity.Player;


    import java.awt.*;
    import java.util.ArrayList;
    import java.util.LinkedList;

public class Controller {
    public static ArrayList<ArrayList<GameObject>> allObjects = new ArrayList<>();
    public static LinkedList<GameObject> toRemove = new LinkedList<>();
    private static final Player player = Player.getInstance();

    public static void updateAll(){
        Entity.list.forEach(e -> {
            e.update();
            player.checkCollision(e);
        });

        Dot.list.forEach(d-> {
            player.checkCollision(d);
        });

        Environment.list.forEach(env -> {
            Entity.list.forEach(entity -> {
                entity.checkCollision(env);
            });
        });

        Timer.list.forEach(timer -> timer.countDown());
        toRemove.forEach(obj -> allObjects.forEach(list -> list.remove(obj)));

    }
    public static void drawAll(Graphics2D g2){
//        drawLines(g2);//DEBUG🐞🐞🪲🐜🐛🦗🪳
        Wall.list.forEach(wall ->  wall.draw(g2));
        allObjects.forEach(list -> list.forEach(obj -> obj.draw(g2)) );
        Score.draw(g2);
        Life.draw(g2);
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


    public static void resetEntities() {
        GameLoop.waitFrames(180);
        Entity.list.forEach(obj -> {
            obj.resetPosition();
            if (obj instanceof Ghost) {
                ((Ghost) obj).setOut();
            }
        });
    }
}
