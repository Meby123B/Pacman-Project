package GameObject;

import Game.ScreenSettings;

import java.awt.*;
import java.util.LinkedList;

public class Teleporter extends GameObject{
    public static LinkedList<Teleporter> list = new LinkedList<>();
    static private int count =0;

    private int goToX;
    private int goToY;

    public Teleporter(int x, int y, int goToX, int goToY) {
        this.x = x;
        this.y = y;
        this.goToX = goToX;
        this.goToY = goToY;

        list.add(this);
    }


    @Override
    public void collideWithPlayer(Player p) {
        teleportTo(p);
    }
    private void teleportTo(Player p) {
        p.setX(goToX);
        p.setY(goToY);
    }
//    @Override
//    public void draw(Graphics2D g2) {
//
//    }
}
