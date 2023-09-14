package GameObject.Menues;

import Game.GameLoop;
import Game.Manager.GameManager;
import Game.Manager.Timer;
import GameObject.GameObject;
import GameObject.Clickable;

import java.awt.*;

public class Button extends GameObject implements Clickable {
    private final String text;

    public Button(int x, int y, String text) {
        super(x, y);
        this.color =  new Color(0x1A1A93);
        this.width = 150;
        this.height = 50;
        this.text = text;
        this.x = x-width/2;
        Menu.list.add(this);
    }

    @Override
    public void whenClicked() {
        this.color =  new Color(0x141472);
        //todo export to Inherit object
        GameLoop.waitFrames(Timer.secondToFrames(0.5));
        GameManager.restart();
        System.out.println("click");
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x,y,width,height);

        g2.setFont(new Font("ariel Script", 1, 20));
        g2.setColor(Color.WHITE);
        g2.drawString(text,x+width/4, (int) (y+height/1.5));
    }

    @Override
    public void whenMouseHover() {
        this.color =  new Color(0x2424C4);
    }

    @Override
    public void whenMouseExit() {
        this.color =  new Color(0x1A1A93);
    }
}
