package GameObject;

import Game.ScreenSettings;

import java.awt.*;
import java.util.ArrayList;

public class Wall extends GameObject {

    public static ArrayList<Wall> list = new ArrayList<>();

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = Color.blue;
        list.add(this);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.fillRect(x, y, width, height);
        int gap = 3 * ScreenSettings.scale;

        g2.setColor(color);
        g2.fillRect(x+gap, y+gap, width-(gap*2), gap);
        g2.fillRect(x+gap, y+gap, gap, height-(gap*2));
        g2.fillRect(x+gap,y+height-(gap*2),width-(gap*2),gap);
        g2.fillRect(x+width-(gap*2),y+gap,gap,height-(gap*2));

    }

    @Override
    public void collideWithPlayer(Player p) {
    }

}
