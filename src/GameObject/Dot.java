package GameObject;

import Game.Controller;
import Game.Manager.Score;
import Game.ScreenSettings;

import java.awt.*;

public class Dot extends GameObject implements Collectable{
    int value;
    public Dot(int x, int y){
        int tileSize = ScreenSettings.tileSize;

        this.x = x + tileSize/4;
        this.y = y + tileSize/4;
        this.width = tileSize / 2;
        this.height = tileSize / 2;
        color = Color.PINK;
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
    @Override
    public void collideWithGhost(Ghost g) { }

}
