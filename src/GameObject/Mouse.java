package GameObject;

import Game.ScreenSettings;

import java.awt.*;

public class Mouse extends GameObject{
    public static Mouse instance;
    public Mouse(){
        this.x=0;
        this.y=0;
        this.height=8;
        this.width=8;
//        this.color= Color.gray; //D🪲
        instance = this;
    }

//    @Override
//    public void draw(Graphics2D g2) {
//
//    }
}
