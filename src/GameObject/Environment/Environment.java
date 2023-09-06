package GameObject.Environment;

import GameObject.*;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;

import java.util.ArrayList;

public class Environment extends GameObject {
    public static ArrayList<GameObject> list = new ArrayList<>();
    @Override
    public void collideWithPlayer(Player p) {

    }

    @Override
    public void collideWithGhost(Ghost g) {

    }
}
