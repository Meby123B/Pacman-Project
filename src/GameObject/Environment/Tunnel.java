
package GameObject.Environment;

import GameObject.*;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;

import java.awt.*;


public class Tunnel extends GameObject {

    public Tunnel(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;

        Environment.list.add(this);
    }


    @Override
    public void collideWithPlayer(Player p) {
        System.out.println("now you going to slow down!!");

    }

    @Override
    public void collideWithGhost(Ghost g) {

    }

    @Override
    public void draw(Graphics2D g2) {
//        g2.setColor(Color.green);
//        g2.fillRect(x, y, width, height);
    }


}

