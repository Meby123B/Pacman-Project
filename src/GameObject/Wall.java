package GameObject;

import java.awt.*;
import java.util.ArrayList;

public class Wall extends GameObject{

    public static ArrayList<Wall> walls = new ArrayList<>();

    public Wall(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = Color.blue;
        walls.add(this);
    }

    @Override
    public void playerCollide(Player p) {}

}
