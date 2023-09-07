package Game.Manager;

import Game.Manager.Level.Level;
import GameObject.Entity.Entity;
import GameObject.Entity.Player;

public class GameManager {
    Level level;

    public static void resetPositions(){
        Entity.list.forEach(obj -> obj.resetPosition());

    }
}
