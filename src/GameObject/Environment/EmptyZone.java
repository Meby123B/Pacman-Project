package GameObject.Environment;

import GameObject.*;

import java.awt.*;


public class EmptyZone extends GameObject {

    public EmptyZone(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;

        Environment.list.add(this);
    }


    @Override
    public void collideWithPlayer(Player p) {

    }

    @Override
    public void collideWithGhost(Ghost g) {

    }

    @Override
    public void draw(Graphics2D g2) {
//        g2.setColor(Color.gray);
//        g2.fillRect(x, y, width, height);
    }
}

