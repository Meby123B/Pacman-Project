package Game.Manager;

import Game.Controller;
import Game.Generator;
import Game.Manager.Level.*;
import Game.Manager.Mode.*;
import Game.ScreenSettings;
import GameObject.Collectables.Collectim;
import GameObject.Collectables.Dot;
import GameObject.Collectables.Fruit;
import GameObject.Entity.Entity;
import GameObject.Entity.Ghost;

import java.awt.*;

public class GameManager {
    private static Level level;

    public static void resetPositions(){
        Entity.list.forEach(obj -> obj.resetPosition());

    }
    public static Level getLevel(){
        return level;
    }
    public static void newGame() {
        level = new Level1();
        Generator.generateAll();
    }
    public static void levelUp(){
        Life._1Up();

        switch (level.getNum()){
            case 1-> level=new Level2();
            case 2-> level=new Level3();
            case 3-> System.out.println("You win!"); //todo win screen
        }
    }
    public static void checkFinishLevel(){
//        System.out.println(Dot.list.size()); //D🪲
        if(Collectim.list.size() == 0){
            levelUp();
            Generator.generateCollectables();
            Controller.resetEntities();
        }
    }
    public static void setBlueMode(){
        Entity.list.forEach(ent -> {
            if (ent instanceof Ghost){
                ((Ghost)ent).setMode(new BlueMode());
            }
        });
    }
    public static void returnToNormalMode(){
        Entity.list.forEach(ent -> {
            if (ent instanceof Ghost){
                ((Ghost)ent).setMode(new NormalMode());
            }
        });
    }

    public static void drawLevel(Graphics2D g2) {
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Segoe Script", Font.ITALIC, 20));
        g2.setPaint(Color.white);

        g2.drawString("Level: "+level.getNum(), 200, ScreenSettings.height+ScreenSettings.tileSize*2);
    }

}
