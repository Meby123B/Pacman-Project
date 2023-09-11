package Game.Manager.Mode;

import GameObject.Entity.Ai.Ai;
import GameObject.Entity.Ghost;
import GameObject.Eatable;

import java.awt.*;

public interface Mode {
    int ghostSpeed();
    Color getGhostColor(Ghost g);
    Ai getGhostAi(Ghost g);
    Eatable whenGhostEaten(Ghost g);
}
