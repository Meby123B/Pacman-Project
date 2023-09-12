package GameObject.Collectables;

import Game.Collision;
import Game.Controller;
import Game.Manager.GameManager;
import Game.Manager.Score;
import Game.Manager.Timer;
import Game.ScreenSettings;
import GameObject.*;
import GameObject.Entity.Player;

import java.awt.*;
import java.util.Random;

public class Fruit extends GameObject implements Collectable, Callable {
    int value;
    Random random = new Random();
    int ts = ScreenSettings.tileSize;

    public Fruit(Color color) {
        super(0, 0, color);

        setTimer();
        randomisePosition();
        resize();

        Collectim.list.add(this);
    }

    private void resize() {
        this.x = x + ts/4;
        this.y = y + ts/4;
        this.width = ts / 2;
        this.height = ts / 2;
    }

    private void setTimer() {
        int timeInSeconds = Timer.secondToFrames(
                GameManager.getLevel().timeForFruit() * random.nextInt(5,10)
        );
        new Timer(timeInSeconds, this);
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
    public void callBack() {
        Controller.removeObj(this);
    }
}
