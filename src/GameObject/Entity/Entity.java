package GameObject.Entity;
import GameObject.*;


import java.util.ArrayList;

public class Entity extends GameObject{
        public static ArrayList<GameObject> list = new ArrayList<>();
    @Override
    public void collideWithPlayer(Player p) {

    }

    @Override
    public void collideWithGhost(Ghost g) {

    }
}
