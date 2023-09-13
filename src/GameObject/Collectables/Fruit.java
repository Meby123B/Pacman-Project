package GameObject.Collectables;

import Animation.ImageTools;
import Game.Collision;
import Game.Controller;
import Game.Manager.GameManager;
import Game.Manager.Score;
import Game.Manager.Timer;
import Game.ScreenSettings;
import GameObject.*;
import GameObject.Entity.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Fruit extends GameObject implements Collectable, Callable {
    int value;
    Random random = new Random();
    int ts = ScreenSettings.tileSize;


    BufferedImage image;

    public Fruit() {
        super(0, 0);

        setTimer();
        randomisePosition();

        Collectim.list.add(this);
    }

    private void setTimer() {
        int timeInSeconds = Timer.secondToFrames(
                GameManager.getLevel().timeForFruit() * random.nextInt(5,10)
        );
        new Timer(timeInSeconds, this);
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    private void randomisePosition() {
        Dot dot;
        do {
            this.x = (random.nextInt(ScreenSettings.maxScreenCol) *ts);
            this.y = (random.nextInt(ScreenSettings.maxScreenRow) *ts);

            dot = new Dot(x, y);

        } while (
                Collision.checkCollisionWithWall(dot)
                        || Collision.checkCollisionWithEnvironment(dot)
        );
    }

    @Override
    public void collideWithPlayer(Player p) {
        collect();
    }

    @Override
    public int getValue() {
        return 0;
    }
    public void setValue(int value) {
        this.value=value;
    }

    @Override
    public void collect() {
        Score.increase(value);
        Controller.removeObj(this);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y,width,height, null);
    }

    @Override
    public void callBack() {
        Controller.removeObj(this);
    }
}
