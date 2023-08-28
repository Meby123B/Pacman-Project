package Elements;

import Game.ScreenSettings;

import java.awt.*;

public abstract class Element {
    int x,y;
    int speed=0;
    ScreenSettings sc = new ScreenSettings();
    abstract void draw(Graphics2D g2);
    abstract int getX();
    abstract void setX(int newX);
    abstract int getY();
    abstract void setY(int newY);
    abstract int getSpeed();

}
