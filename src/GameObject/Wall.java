package GameObject;

import Game.ScreenSettings;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;

import java.awt.*;
import java.util.ArrayList;

public class Wall extends GameObject {

    public static ArrayList<Wall> list = new ArrayList<>();

    public Wall(int x, int y, int w, int h) {
        super(x,y,Color.BLUE);

        this.width = w;
        this.height = h;
        list.add(this);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.fillRect(x, y, width, height);
        int gap = (int)(3 * ScreenSettings.scale);

        g2.setColor(color);
        g2.fillRect(x+gap, y+gap, width-(gap*2), gap);
        g2.fillRect(x+gap, y+gap, gap, height-(gap*2));
        g2.fillRect(x+gap,y+height-(gap*2),width-(gap*2),gap);
        g2.fillRect(x+width-(gap*2),y+gap,gap,height-(gap*2));

    }


}
