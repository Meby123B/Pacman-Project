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
        this.color = Color.WHITE;
        walls.add(this);
    }

    @Override
    public void playerCollide() {
        System.out.println("DON'T TOUCH ME!");
    }

//    @Override
//    public int getLeft() {
//        return 0;
//    }
//
//    @Override
//    public int getRight() {
//        return 50;
//    }
//
//    @Override
//    public int getUp() {
//        return 0;
//    }
//
//    @Override
//    public int getDown() {
//        return ScreenSettings.height;
//    }


}
