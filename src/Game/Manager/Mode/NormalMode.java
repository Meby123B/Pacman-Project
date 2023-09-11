package Game.Manager.Mode;

import GameObject.Entity.Ai.Ai;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;
import GameObject.Eatable;

import java.awt.*;

public class NormalMode implements Mode{
    @Override
    public int ghostSpeed() {
        return 2;
    }

    @Override
    public Color getGhostColor(Ghost g) {
        return g.getColor();
    }

    @Override
    public Ai getGhostAi(Ghost g) {
        return g.getAi();
    }

    @Override
    public Eatable whenGhostEaten(Ghost g) {
        return Player.getInstance();
    }
}
