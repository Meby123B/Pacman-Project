package GameObject.Collectables;

import Game.Controller;
import Game.Manager.Score;
import Game.Manager.Timer;
import Game.ScreenSettings;
import GameObject.Entity.Player;
import GameObject.*;

import java.awt.*;
import java.util.ArrayList;

public class Dot extends GameObject implements Collectable{//, Clickable {
    int value;
    public Dot(int x, int y){
        super(x,y,Color.PINK);
        int tileSize = ScreenSettings.tileSize;

        this.x = x + tileSize/4;
        this.y = y + tileSize/4;
        this.width = tileSize / 2;
        this.height = tileSize / 2;
        value = 10;
    }
    public void collideWithPlayer(Player p){
        collect();
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

//    @Override
//    public void whenClicked() {
//        collect();
//    }
}
