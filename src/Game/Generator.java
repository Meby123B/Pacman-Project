package Game;

import GameObject.Dot;
import GameObject.Ghost;
import GameObject.Player;
import GameObject.Wall;

public class Generator {
    static int tileSize = ScreenSettings.tileSize;
    static int scrHeight = ScreenSettings.height;
    static int scrWidth = ScreenSettings.width;

    public static void generateWalls(){
        new Wall(0,0, scrWidth, tileSize); //top
        new Wall(0,scrHeight-tileSize, scrWidth, tileSize); //bottom
        new Wall(0,0, tileSize, scrHeight); //left
        new Wall(scrWidth-tileSize,0, tileSize, scrHeight); //right

        new Wall(tileSize*10,tileSize*10, tileSize, tileSize*10);
    }
    public static void generateDots(){
        Dot dot = new Dot();
        Dot dot2 = new Dot();

        for (int i = 0; i < 25; i++) {

        }

        Controller.allObjects.add(dot);
        Controller.allObjects.add(dot2);
    }
    public static void generateEntity(){
        Player player = Player.getInstance();
        Ghost ghost = new Ghost();

        Controller.allObjects.add(player);
        Controller.allObjects.add(ghost);

    }

    public static void generateAll() {
        generateDots();
        generateEntity();
        generateWalls();
    }
}
