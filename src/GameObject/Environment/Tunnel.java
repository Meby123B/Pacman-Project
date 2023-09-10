
package GameObject.Environment;

import GameObject.*;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;

import java.awt.*;


public class Tunnel extends GameObject {

    public Tunnel(int x, int y, int w, int h) {
        super(x,y,null);
        this.width = w;
        this.height = h;

        Environment.list.add(this);
    }


    @Override
    public void collideWithGhost(Ghost g) {
        System.out.println("now you going to slow down!!");

    }

    @Override
    public void draw(Graphics2D g2) {
//        g2.setColor(Color.green);
//        g2.fillRect(x, y, width, height);
    }


}

