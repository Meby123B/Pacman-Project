package GameObject.Environment;

import GameObject.*;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;

import java.awt.*;

public class Teleporter extends GameObject {
    static private int count =0;

    private int goToX;
    private int goToY;

    public Teleporter(int x, int y, int goToX, int goToY) {
        super(x,y,null);
        this.goToX = goToX;
        this.goToY = goToY;

        Environment.list.add(this);
    }


    @Override
    public void collideWithPlayer(Player p) {
        teleportTo(p);
    }
    @Override
    public void collideWithGhost(Ghost g) {
        teleportTo(g);
    }
    private void teleportTo(GameObject obj) {
        obj.setX(goToX);
        obj.setY(goToY);
    }
    @Override
    public void draw(Graphics2D g2) {}
}
