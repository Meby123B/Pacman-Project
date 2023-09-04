package GameObject;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Zone extends GameObject{
    public static LinkedList<Zone> list = new LinkedList<>();

    private ZoneTypes type;

    public Zone(ZoneTypes type, int x, int y, int w, int h) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;

        list.add(this);
    }


    @Override
    public void collideWithPlayer(Player p) {
//        if (type == ZoneTypes.TELEPORTER) teleportTo(p);
    }
    @Override
    public void draw(Graphics2D g2) {

    }
}
