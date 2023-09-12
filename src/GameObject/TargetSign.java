package GameObject;

import java.awt.*;
import java.util.ArrayList;

public class TargetSign extends GameObject{
    public static ArrayList<GameObject> list = new ArrayList<>();

    public TargetSign(int x, int y, Color color) {
        super(x, y, color);
        list.add(this);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(x,y, x + (width/3), y);
        g2.drawLine(x,y, x, y + (height/3));

        g2.drawLine((x+width),y, (x+width) - (width/3), y);
        g2.drawLine((x+width),y, (x+width), y + (height/3));

        g2.drawLine(x,(y+height), x + (width/3), (y+height));
        g2.drawLine(x,(y+height), x, (y + height) - (height/3));

        g2.drawLine((x+width),(y+height), (x+width) - (width/3), (y+height));
        g2.drawLine((x+width),(y+height), (x+width), (y + height) - (height/3));

    }
}
