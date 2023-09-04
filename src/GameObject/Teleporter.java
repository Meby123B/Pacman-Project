package GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Teleporter extends GameObject{
    public static LinkedList<Teleporter> list = new LinkedList<>();
    static private int count =0;

    private int id;
    private int goTo;

    public Teleporter(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        setId(this);
        list.add(this);
    }


    @Override
    public void playerCollide(Player p) {

    }
    private void setId(Teleporter teleporter) {
        id = count++;
        if (count %2 == 1){
            goTo = count;
        } else {
            goTo = count -2;
        }
    }

    private void teleportTo(Player p) {
        Teleporter exit = list.get(goTo);
        p.setX(exit.getX());
        p.setY(exit.getY());
    }
    @Override
    public void draw(Graphics2D g2) {

    }
}
