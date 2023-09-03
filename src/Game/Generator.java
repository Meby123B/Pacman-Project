package Game;

import GameObject.*;

import java.awt.*;
import java.util.Random;

public class Generator {
    static int tileSize = ScreenSettings.tileSize;
    static int scrHeight = ScreenSettings.height;
    static int scrWidth = ScreenSettings.width;

    private static void generateWalls(){
        int ts = tileSize;
        new Wall(0,0, scrWidth, ts); //top
        new Wall(0,scrHeight-ts, scrWidth, ts); //bottom
        new Wall(0,0, ts, scrHeight); //left
        new Wall(scrWidth-ts,0, ts, scrHeight); //right


        new Wall(ts*2,ts*2,ts*4,ts*3);
        new Wall(ts*7,ts*2,ts*5,ts*3);
        new Wall(ts*13,0,ts*2,ts*5);
        new Wall(ts*16,ts*2,ts*5,ts*3);
        new Wall(ts*22,ts*2,ts*4,ts*3);

        new Wall(ts*2,ts*6,ts*4,ts*2);
        new Wall(ts*7,ts*6,ts*2,ts*8);
        new Wall(ts*10,ts*6,ts*8,ts*2);
        new Wall(ts*13,ts*6,ts*2,ts*5);
        new Wall(ts*19,ts*6,ts*2,ts*8);
        new Wall(ts*22,ts*6,ts*4,ts*2);

        new Wall(0,ts*9,ts*6,ts*5);
        new Wall(ts*7,ts*9,ts*5,ts*2);
        new Wall(ts*16,ts*9,ts*5,ts*2);
        new Wall(ts*22,ts*9,ts*6,ts*5);

        new Wall(ts*10,ts*12,ts*8,ts*5);

        new Wall(0,ts*15,ts*6,ts*5);
        new Wall(ts*7,ts*15,ts*2,ts*5);
        new Wall(ts*19,ts*15,ts*2,ts*5);
        new Wall(ts*22,ts*15,ts*6,ts*5);

        new Wall(ts*10,ts*18,ts*8,ts*2);
        new Wall(ts*13,ts*18,ts*2,ts*5);

        new Wall(ts*2,ts*21,ts*4,ts*2);
        new Wall(ts*4,ts*21,ts*2,ts*5);
        new Wall(ts*7,ts*21,ts*5,ts*2);
        new Wall(ts*16,ts*21,ts*5,ts*2);
        new Wall(ts*22,ts*21,ts*4,ts*2);
        new Wall(ts*22,ts*21,ts*2,ts*5);

        new Wall(ts*0,ts*24,ts*3,ts*2);
        new Wall(ts*7,ts*24,ts*2,ts*5);
        new Wall(ts*10,ts*24,ts*8,ts*2);
        new Wall(ts*13,ts*24,ts*2,ts*5);
        new Wall(ts*19,ts*24,ts*2,ts*5);
        new Wall(ts*25,ts*24,ts*3,ts*2);

        new Wall(ts*2,ts*27,ts*10,ts*2);
        new Wall(ts*16,ts*27,ts*10,ts*2);
    }
    private static void generateDots(){

        Random rand = new Random();
        int x,y;
        Dot dot;

        for (int i = 0; i < 200; i++) {
            x = rand.nextInt(ScreenSettings.maxScreenCol);
            y = rand.nextInt(ScreenSettings.maxScreenRow);

            dot = new Dot(x*tileSize,y*tileSize);
            if (Movement.checkWallCollision(dot)){
//                System.out.println("aya!"); //D🪲 happened?
                i--;
                continue;
            }
            Controller.allObjects.add(dot);
            System.out.println(Controller.allObjects.size()); //D🪲 check how many dots generated
        }

    }
    private static void generateEntity(){

        Player player = Player.getInstance();
        Ghost ghost1 = new Ghost(tileSize*13 + tileSize/2,tileSize*11, Color.RED);
        Ghost ghost3 = new Ghost(tileSize*12 + tileSize/2,tileSize*14, Color.CYAN);
        Ghost ghost2 = new Ghost(tileSize*13 + tileSize/2,tileSize*14, Color.PINK);
        Ghost ghost4 = new Ghost(tileSize*14 + tileSize/2,tileSize*14, Color.ORANGE);


        Controller.allObjects.add(player);
//        Controller.allObjects.add(ghost);



            Controller.allObjects.add(ghost1);
            Controller.ghosts.add(ghost1);
            Controller.allObjects.add(ghost2);
            Controller.ghosts.add(ghost2);
            Controller.allObjects.add(ghost3);
            Controller.ghosts.add(ghost3);
            Controller.allObjects.add(ghost4);
            Controller.ghosts.add(ghost4);


    }

    public static void generateAll() {

        generateWalls();
        generateDots();
        generateEntity();
    }
}
