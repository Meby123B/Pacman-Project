package GameObject;

import Game.ScreenSettings;

import java.awt.*;
import java.util.ArrayList;

public class Wall extends GameObject{

    public static ArrayList<Wall> walls = new ArrayList<>();

    public Wall(){
        this.x = 0;
        this.y = 0;
        this.width = 50;
        this.height = ScreenSettings.height;
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
