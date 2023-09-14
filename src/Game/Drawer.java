package Game;

import Game.Manager.GameManager;
import Game.Manager.Life;
import Game.Manager.Score;
import GameObject.GameObject;
import GameObject.Menues.Menu;
import GameObject.TargetSign;
import GameObject.Wall;

import java.awt.*;

public class Drawer {
    public static void drawAll(Graphics2D g2){
        Wall.list.forEach(wall ->  wall.draw(g2));
        Controller.allObjects.forEach(list -> list.forEach(obj -> obj.draw(g2)) );
        Score.draw(g2);
        Life.draw(g2);
        GameManager.drawLevel(g2);

        Menu.list.forEach(m -> ((GameObject)m).draw(g2));

//        drawLines(g2);//DEBUG🐞🐞🪲🐜🐛🦗🪳
//        TargetSign.list.forEach(target-> target.draw(g2));
    }

    //DEBUG🐞🐞🪲🐜🐛🦗🪳
    private static void drawLines(Graphics2D g2) {
        Color color = Color.PINK;
        g2.setColor(color);
        int start,end, pos;
        start=0;

        end = ScreenSettings.width;
        for (int i = 0; i < ScreenSettings.maxScreenRow; i++) {
            pos = i*ScreenSettings.tileSize;
            g2.drawLine(start,pos,end,pos);
        }

        end = ScreenSettings.height;
        for (int i = 0; i < ScreenSettings.maxScreenCol; i++) {
            pos = i*ScreenSettings.tileSize;
            g2.drawLine(pos,start,pos,end);
        }

    }
}
