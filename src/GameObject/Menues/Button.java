package GameObject.Menues;

import Game.Manager.GameManager;
import GameObject.GameObject;
import GameObject.Clickable;

import java.awt.*;

public class Button extends GameObject implements Clickable {
    public Button(int x, int y, Color color) {
        super(x, y, color);
        Menu.list.add(this);
    }

    @Override
    public void whenClicked() {
        GameManager.restart();
        System.out.println("click");
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
    }
}
