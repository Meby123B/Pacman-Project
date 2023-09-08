package Game.Manager.Mode;

import GameObject.Entity.Ai;
import GameObject.Entity.Ghost;
import GameObject.Eatable;
import GameObject.GameObject;

import java.awt.*;

public class BlueMode implements Mode{
    @Override
    public int ghostSpeed() {
        return 1;
    }
    @Override
    public Color getGhostColor(Ghost g) {
        return Color.BLUE;
    }

    @Override
    public Ai getGhostAi(Ghost g) {
        System.out.println("run");
        return new Ai();
//        return Ai.runFromPlayer();//todo
    }

    @Override
    public Eatable whenGhostEaten(Ghost g) {
        return g;
    }
}
