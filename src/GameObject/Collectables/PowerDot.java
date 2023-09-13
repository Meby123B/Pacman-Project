package GameObject.Collectables;

import Game.Controller;
import Game.Manager.GameManager;
import Game.Manager.Score;
import Game.Manager.Timer;
import GameObject.Entity.Player;
import GameObject.*;

import java.awt.*;

public class PowerDot extends GameObject implements Collectable, Callable {
    int value;
    private static final int timeInSeconds = Timer.secondToFrames(
            GameManager.getLevel().timeForBlueMode()
    );
    private static Timer blueModeTimer;
    public PowerDot(int x, int y){
        super(x,y,new Color(0xffb897));

        value = 50;
        Collectim.list.add(this);
    }
    public void collideWithPlayer(Player p){
        collect();

        GameManager.setBlueMode();
    }


    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void collect() {
        Score.increase(value);
        setTimer();
        Controller.removeObj(this);
    }

    private void setTimer() {
        if (blueModeTimer == null){
            blueModeTimer = new Timer(timeInSeconds,this);
        } else {
            blueModeTimer.reset();
        }
    }

    @Override
    public void callBack() {
        GameManager.returnToNormalMode();
    }
}
