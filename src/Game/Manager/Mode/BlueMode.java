package Game.Manager.Mode;

import GameObject.Entity.Ai.Ai;
import GameObject.Entity.Ghost;
import GameObject.Eatable;

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
        if (g.isEaten){
            return g.getAi();
        }
        return new GameObject.Entity.Ai.BlueMode(g);
//        return Ai.runFromPlayer();//todo
    }

    @Override
    public Eatable whenGhostEaten(Ghost g) {
        return g;
    }
}
