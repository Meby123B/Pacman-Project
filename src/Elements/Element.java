package Elements;

import Game.ScreenSettings;

import java.awt.*;

public abstract class Element {
    int x,y;
    ScreenSettings sc = new ScreenSettings();
    abstract void draw(Graphics2D g2);

}
