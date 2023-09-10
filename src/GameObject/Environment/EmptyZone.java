package GameObject.Environment;

import GameObject.*;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;

import java.awt.*;


public class EmptyZone extends GameObject {

    public EmptyZone(int x, int y, int w, int h) {
        super(x,y,null);
        this.width = w;
        this.height = h;

        Environment.list.add(this);
    }


    @Override
    public void draw(Graphics2D g2) {
//        g2.setColor(Color.gray);
//        g2.fillRect(x, y, width, height);
    }
}

