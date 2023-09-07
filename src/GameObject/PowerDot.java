package GameObject;

import Game.Controller;
import Game.Manager.GameManager;
import Game.Manager.Mode.BlueMode;
import Game.Manager.Score;
import Game.ScreenSettings;
import GameObject.Entity.Player;

import java.awt.*;
import java.util.ArrayList;

public class PowerDot extends GameObject implements Collectable{
    public static ArrayList<GameObject> list = new ArrayList<>();
    int value;
    public PowerDot(int x, int y){
        int tileSize = ScreenSettings.tileSize;

        this.x = x ;
        this.y = y ;
        this.height = tileSize;
        this.width = tileSize;
        color = Color.green;
        value = 50;
    }
    public void collideWithPlayer(Player p){
        collect();
        GameManager.gameMode = new BlueMode();
    }


    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void collect() {
        Score.increase(value);
        Controller.removeObj(this);
    }

}
