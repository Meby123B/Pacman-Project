package Elements;

import Game.ScreenSettings;
import Game.KeyHandler;

import java.awt.*;

public class Player extends Entity implements Drawable{
    KeyHandler keyH;

    public  Player( KeyHandler keyH){
        this.keyH = keyH;
        x = 100;
        y = 100;
        speed = 4;
    }
public void update() {
    if (keyH.upPressed) {
        y -= speed;

    } else if (keyH.downPressed) {
        y += speed;

    } else if (keyH.leftPressed) {
        x -= speed;

    } else if (keyH.rightPressed) {
        x += speed;
    }
}
    public void draw(Graphics2D g2, ScreenSettings sc) {
        g2.setColor(Color.WHITE);
        g2.fillRect(x,y,sc.tileSize,sc.tileSize);
    }
}
