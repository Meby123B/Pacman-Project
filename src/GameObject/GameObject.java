package GameObject;

import Game.ScreenSettings;

import java.awt.*;

public abstract class GameObject {
    int x,y;
    int speed=0;
    ScreenSettings sc = new ScreenSettings();
    abstract void draw(Graphics2D g2);

    abstract int getLeft();
    abstract int getRight();
    abstract int getUp();
    abstract int getDown();

    abstract int getX();
    abstract void setX(int newX);
    abstract int getY();
    abstract void setY(int newY);

    abstract int getSpeed();

}
