package GameObject.Collectables;

import Game.Controller;
import Game.Manager.GameManager;
import Game.Manager.Mode.BlueMode;
import Game.Manager.Score;
import Game.Manager.Timer;
import Game.ScreenSettings;
import GameObject.Entity.Player;
import GameObject.*;

import java.awt.*;
import java.util.ArrayList;

public class PowerDot extends GameObject implements Collectable, Callable {
    int value;
    public PowerDot(int x, int y){
        super(x,y,Color.green);

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
        new Timer(GameManager.level.timeForBlueMode(), this);
        Controller.removeObj(this);
    }

    @Override
    public void callBack() {
        GameManager.returnToNormalMode();
    }
}
