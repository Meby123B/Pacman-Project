package Game.Manager;

import Game.Manager.Level.Level;
import Game.Manager.Mode.BlueMode;
import Game.Manager.Mode.Mode;
import Game.Manager.Mode.NormalMode;
import GameObject.Entity.Entity;
import GameObject.Entity.Player;

public class GameManager {
    public static Level level;
    public static Mode gameMode = new BlueMode();

    public static void resetPositions(){
        Entity.list.forEach(obj -> obj.resetPosition());

    }
}
