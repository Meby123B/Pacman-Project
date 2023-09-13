package Game.Manager.Mode;

import Animation.ImageTools;
import GameObject.Entity.Ai.Ai;
import GameObject.Entity.Ghost;
import GameObject.Eatable;

import java.awt.image.BufferedImage;

public class BlueMode implements Mode {
    Ai ai = new GameObject.Entity.Ai.BlueMode(null);
    String path = "/Ghosts/BlueMode.png";
    private final BufferedImage image = new ImageTools().getImage(path);

    @Override
    public int ghostSpeed(Ghost g) {
        return 1;
    }

    @Override
    public BufferedImage getGhostImage(Ghost g) {
        return image;
    }

    @Override
    public Ai getGhostAi(Ghost g) {
        return ai;
    }

    @Override
    public Eatable whenGhostEaten(Ghost g) {
        return g;
    }
}
