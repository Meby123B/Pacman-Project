package Game;

    import Game.Manager.GameManager;
    import Game.Manager.Timer;
    import GameObject.*;
    import GameObject.Entity.Entity;
    import GameObject.Entity.Ghost;
    import GameObject.Entity.*;
    import GameObject.Collectables.FruitGenerator;


    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.Stack;

public class Controller {
    public static ArrayList<ArrayList<GameObject>> allObjects = new ArrayList<>();
    public static Stack<GameObject> toRemove = new Stack<>();
    public static LinkedList<Timer> TimerToRemove = new LinkedList<>();
//    private static final Player player = Player.getInstance();

    public static void updateAll(){
        Entity.list.forEach(e -> e.update());
        Collision.checkAll();

        GameManager.checkFinishLevel();

        Timer.list.forEach(timer -> timer.countDown());
        FruitGenerator.checkForGenerate();

        toRemove.forEach(obj -> allObjects.forEach(list -> list.remove(obj)));
        TimerToRemove.forEach(timer -> Timer.list.remove(timer));

    }



    public static void removeObj(GameObject obj){
        toRemove.push(obj);
    }
    public static void removeTimer(Timer timer){
        TimerToRemove.push(timer);
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
