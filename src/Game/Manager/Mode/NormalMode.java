package Game.Manager.Mode;

import GameObject.Entity.Ai.Ai;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;
import GameObject.Eatable;

import java.awt.image.BufferedImage;

public class NormalMode implements Mode{
    @Override
    public int ghostSpeed(Ghost g) {
        return 2;
    }

    @Override
    public BufferedImage getGhostImage(Ghost g) {
        return g.getImage();
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
