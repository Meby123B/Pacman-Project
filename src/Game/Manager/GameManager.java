package Game.Manager;

import Game.Controller;
import Game.Manager.Level.*;
import Game.Manager.Mode.*;
import Game.ScreenSettings;
import GameObject.Collectables.Collectim;
import GameObject.Collectables.Dot;
import GameObject.Entity.Entity;

import java.awt.*;

public class GameManager {
    public static Level level = new Level3();
    private static Mode gameMode = new NormalMode();
//    public static Mode gameMode = new NormalMode();

    public static void resetPositions(){
        Entity.list.forEach(obj -> obj.resetPosition());

    }
    public static Level getLevel(){
        return level;
    }
    public static void levelUp(){
        switch (level.getNum()){
            case 1-> level=new Level2();
            case 2-> level=new Level3();
        }
    }
    public static void checkFinishLevel(){
//        System.out.println(Dot.list.size());
        if(Collectim.list.size() == 0){
            levelUp();
            //todo generate new Dots
            Controller.resetEntities();
        }
    }
    public static Mode getGameMode(){
        return gameMode;
    }
    public static void setBlueMode(){
        gameMode = new BlueMode();
    }
    public static void returnToNormalMode(){
        gameMode = new NormalMode();
    }

    public static void drawLevel(Graphics2D g2) {
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Segoe Script", Font.ITALIC, 20));
        g2.setPaint(Color.white);

        g2.drawString("Level: "+level.getNum(), 200, ScreenSettings.height+ScreenSettings.tileSize*2);
    }

}
