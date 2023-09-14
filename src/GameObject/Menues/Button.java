package GameObject.Menues;

import GameObject.GameObject;
import GameObject.Clickable;

import java.awt.*;

public class Button extends GameObject implements Clickable {
    public Button(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void whenClicked() {

    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
    }
}
