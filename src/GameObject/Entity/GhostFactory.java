package GameObject.Entity;

import Game.ScreenSettings;
import GameObject.Entity.Ai.*;

public class GhostFactory {
    private static int ts = ScreenSettings.tileSize;
    public static Ghost makeBlinky(){
        String path = "/Ghosts/Blinky.png";
        Ghost ghost =new Ghost(ts * 13 + ts / 2, ts * 11, path);
        ghost.setAi( new Blinky(ghost));
        return ghost;
    }
    public static Ghost makePinky(){
        String path = "/Ghosts/Pinky.png";
        Ghost ghost = new Ghost(ts * 13 + ts / 2, ts * 14, path);
        ghost.setAi( new Pinky(ghost));
        return ghost;
    }
    public static Ghost makeInky(){
        String path = "/Ghosts/Inky.png";
        Ghost ghost = new Ghost(ts * 12 + ts / 2, ts * 14, path);
        ghost.setAi( new Inky(ghost));
        return ghost;
    }
    public static Ghost makeClyde(){
        String path = "/Ghosts/Clyde.png";
        Ghost ghost = new Ghost(ts * 14 + ts / 2, ts * 14, path);
        ghost.setAi( new Clyde(ghost));
        return ghost;
    }



}
