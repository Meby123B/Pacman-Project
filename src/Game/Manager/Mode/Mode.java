package Game.Manager.Mode;

import GameObject.Entity.Ai.Ai;
import GameObject.Entity.Ghost;
import GameObject.Eatable;

import java.awt.image.BufferedImage;

public interface Mode {
    int ghostSpeed(Ghost g);
    BufferedImage getGhostImage(Ghost g);
    Ai getGhostAi(Ghost g);
    Eatable whenGhostEaten(Ghost g);
}
