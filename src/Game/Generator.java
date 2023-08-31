package Game;

import GameObject.Dot;
import GameObject.Ghost;
import GameObject.Player;
import GameObject.Wall;

public class Generator {
    public static void generateWalls(){
        new Wall(0,0, 20, ScreenSettings.height);
        new Wall(ScreenSettings.width-20,0, 20, ScreenSettings.height);
        new Wall(200,170, 20, ScreenSettings.height);
    }
    public static void generateDots(){
        Dot dot = new Dot();
        Dot dot2 = new Dot();

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
