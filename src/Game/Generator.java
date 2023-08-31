package Game;

import GameObject.*;

import java.util.Random;

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
        new Wall(tileSize*13,tileSize*10, tileSize, tileSize*10);
        new Wall(tileSize*15,tileSize*10, tileSize, tileSize*10);
        new Wall(tileSize*10,tileSize*8, tileSize*10, tileSize);
        new Wall(tileSize*15,tileSize*10, tileSize*10, tileSize);
    }
    public static void generateDots(){

        Random rand = new Random();
        int x,y;
        Dot dot;

        for (int i = 0; i < 50; i++) {
            x = rand.nextInt(ScreenSettings.maxScreenCol);
            y = rand.nextInt(ScreenSettings.maxScreenRow);

            dot = new Dot(x*tileSize,y*tileSize);
            if (Movement.checkWallCollision(dot)){
                System.out.println("aya!");
                continue;
            }
            Controller.allObjects.add(dot);
        }

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
