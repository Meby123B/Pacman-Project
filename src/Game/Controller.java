package Game;

    import Game.Manager.GameManager;
    import Game.Manager.Timer;
    import GameObject.*;
    import GameObject.Collectables.Collectim;
    import GameObject.Entity.Entity;
    import GameObject.Entity.Ghost;
    import GameObject.Entity.*;
    import GameObject.Collectables.FruitGenerator;


    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.Stack;

public class Controller {
    public static LinkedList<LinkedList<GameObject>> allObjects = new LinkedList<>();
    public static Stack<GameObject> toRemove = new Stack<>();
    public static Stack<Timer> TimerToRemove = new Stack<>();
//    static GhostReleaserManager ghostReleaserManager = new GhostReleaserManager();


    public static void updateAll(){
        if (GameManager.isGameover()){
            return;
        }

        Entity.list.forEach(e -> e.update());
        Collision.checkAll();
        GhostReleaserManager.check();
        GameManager.checkFinishLevel();

        Timer.list.forEach(timer -> timer.countDown());
        FruitGenerator.checkForGenerate();

        removeFromStack();
//        toRemove.forEach(obj -> allObjects.forEach(list -> list.remove(obj)));
//        TimerToRemove.forEach(timer -> Timer.list.remove(timer));

    }

    private static void removeFromStack() {
        if (toRemove.isEmpty()) return;

        GameObject obj = toRemove.pop();
        if (obj instanceof Collectable) {
            Collectim.list.remove(obj);
        }
    }


    public static void removeObj(GameObject obj){
        toRemove.push(obj);
    }
//    public static void removeTimer(Timer timer){
//        TimerToRemove.push(timer);
//    }


    public static void resetEntities() {
        GameLoop.waitFrames(Timer.secondToFrames(1));
        Entity.list.forEach(obj -> {
            obj.resetPosition();
        });
        GhostReleaserManager.setAllUnrealesde();

    }
}
