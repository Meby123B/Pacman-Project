package GameObject.Entity;

import Game.ScreenSettings;

import java.awt.*;

public class GhostFactory {
    private static int ts = ScreenSettings.tileSize;
    public static Ghost makeBlinky(){
        return new Ghost(ts * 13 + ts / 2, ts * 11, Color.RED);
    }
    public static Ghost makePinky(){
        return new Ghost(ts * 13 + ts / 2, ts * 14, Color.magenta);
    }
    public static Ghost makeInky(){
        return new Ghost(ts * 12 + ts / 2, ts * 14, Color.CYAN);
    }
    public static Ghost makeClyde(){
        return new Ghost(ts * 14 + ts / 2, ts * 14, Color.ORANGE);
    }



}
