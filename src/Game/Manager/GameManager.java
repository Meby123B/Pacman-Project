package Game.Manager;

import GameObject.Entity.Entity;
import GameObject.Entity.Player;

public class GameManager {

    public static void resetPositions(){
        Entity.list.forEach(obj -> obj.resetPosition());

    }
}
