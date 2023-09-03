package GameObject;

import Game.Controller;
import Game.ScreenSettings;

import java.awt.*;

public class Dot extends GameObject implements Collectable{
    static int score = 0;
    int value;
    public Dot(int x, int y){
        int tileSize = ScreenSettings.tileSize;

        this.x = x + tileSize/4;
        this.y = y + tileSize/4;
        this.width = tileSize / 2;
        this.height = tileSize / 2;
        color = Color.PINK;
        value = 100;
    }
    public void playerCollide(Player p){
        collect();
    }


    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void collect() {
        score += value;
        System.out.println(score);
        Controller.removeObj(this);
    }

}
