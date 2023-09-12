package GameObject.Entity;

import Game.ScreenSettings;
import GameObject.Entity.Ai.*;

import java.awt.*;

public class GhostFactory {
    private static int ts = ScreenSettings.tileSize;
    public static Ghost makeBlinky(){
        Ghost ghost =new Ghost(ts * 13 + ts / 2, ts * 11, Color.RED);
        ghost.setAi( new Blinky(ghost));
        return ghost;
    }
    public static Ghost makePinky(){
        Ghost ghost = new Ghost(ts * 13 + ts / 2, ts * 14, Color.magenta);
        ghost.setAi( new Pinky(ghost));
        return ghost;
    }
    public static Ghost makeInky(){
        Ghost ghost = new Ghost(ts * 12 + ts / 2, ts * 14, Color.CYAN);
        ghost.setAi( new Inky(ghost));
        return ghost;
    }
    public static Ghost makeClyde(){
        Ghost ghost = new Ghost(ts * 14 + ts / 2, ts * 14, Color.ORANGE);
        ghost.setAi( new Clyde(ghost));
        return ghost;
    }



}
