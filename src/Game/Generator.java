package Game;

import GameObject.*;
import GameObject.Collectables.*;
import GameObject.Entity.Entity;
import GameObject.Entity.GhostFactory;
import GameObject.Entity.Player;
import GameObject.Environment.*;
import GameObject.Menues.Button;

import java.awt.*;

public class Generator {
    static int ts = ScreenSettings.tileSize;
    static int scrHeight = ScreenSettings.height;
    static int scrWidth = ScreenSettings.width;

    private static void generateWalls() {


        //line 1
        new Wall(ts * 2, ts * 2, ts * 4, ts * 3);
        new Wall(ts * 7, ts * 2, ts * 5, ts * 3);
        new Wall(ts * 13, 0, ts * 2, ts * 5);
        new Wall(ts * 16, ts * 2, ts * 5, ts * 3);
        new Wall(ts * 22, ts * 2, ts * 4, ts * 3);

        //line 3 middle
        new Wall(ts * 7, ts * 9, ts * 5, ts * 2);
        new Wall(ts * 16, ts * 9, ts * 5, ts * 2);

        //line 2
        new Wall(ts * 2, ts * 6, ts * 4, ts * 2);
        new Wall(ts * 7, ts * 6, ts * 2, ts * 8);
        new Wall(ts * 13, ts * 6, ts * 2, ts * 5);
        new Wall(ts * 10, ts * 6, ts * 8, ts * 2);
        new Wall(ts * 19, ts * 6, ts * 2, ts * 8);
        new Wall(ts * 22, ts * 6, ts * 4, ts * 2);

        //line 3
        new Wall(0, ts * 9, ts * 6, ts * 5);
        new Wall(ts * 22, ts * 9, ts * 6, ts * 5);


        // ghosts cell
        new Wall(ts * 10, ts * 12, ts * 8, ts * 5);

        //line 4
        new Wall(0, ts * 15, ts * 6, ts * 5);
        new Wall(ts * 7, ts * 15, ts * 2, ts * 5);
        new Wall(ts * 19, ts * 15, ts * 2, ts * 5);
        new Wall(ts * 22, ts * 15, ts * 6, ts * 5);

        new Wall(ts * 13, ts * 18, ts * 2, ts * 5);
        new Wall(ts * 10, ts * 18, ts * 8, ts * 2);

        //line 5
        new Wall(ts * 4, ts * 21, ts * 2, ts * 5);
        new Wall(ts * 2, ts * 21, ts * 4, ts * 2);
        new Wall(ts * 7, ts * 21, ts * 5, ts * 2);
        new Wall(ts * 16, ts * 21, ts * 5, ts * 2);
        new Wall(ts * 22, ts * 21, ts * 2, ts * 5);
        new Wall(ts * 22, ts * 21, ts * 4, ts * 2);

        //line 6
        new Wall(ts * 0, ts * 24, ts * 3, ts * 2);
        new Wall(ts * 7, ts * 24, ts * 2, ts * 5);
        new Wall(ts * 13, ts * 24, ts * 2, ts * 5);
        new Wall(ts * 10, ts * 24, ts * 8, ts * 2);
        new Wall(ts * 19, ts * 24, ts * 2, ts * 5);
        new Wall(ts * 25, ts * 24, ts * 3, ts * 2);

        new Wall(ts * 16, ts * 27, ts * 10, ts * 2);
        new Wall(ts * 2, ts * 27, ts * 10, ts * 2);

        new Wall(0, 0, ts, (ts * 14)); //left
        new Wall(0, (ts * 15), ts, (ts * 16)); //left
        new Wall(scrWidth - ts, 0, ts, (ts * 14)); //right
        new Wall(scrWidth - ts, (ts * 15), ts, (ts * 16)); //right
        new Wall(0, 0, scrWidth, ts); //top
        new Wall(0, scrHeight - ts, scrWidth, ts); //bottom
    }

    public static void generateCollectables() {
        if (Collectim.list.size() > 0){
            Collectim.list.clear();
        }

        new PowerDot(1 * ts, 3 * ts);
        new PowerDot(26 * ts, 3 * ts);
        new PowerDot(1 * ts, 23 * ts);
        new PowerDot(26 * ts, 23 * ts);

        int x, y;
        Dot dot;

        for (x = 0; x < ScreenSettings.maxScreenCol; x++) {
            for (y = 0; y < ScreenSettings.maxScreenRow; y++) {

                dot = new Dot(x * ts, y * ts);
                if (
                        Collision.checkCollisionWithEnvironment(dot)
                        || Collision.checkCollisionWithWall(dot)
                ) {
//                    System.out.println("aya!"); //D🪲 happened?
                    continue;
                }
                Collectim.list.add(dot);
//                System.out.println(Dot.list.size()); //D🪲 check how many dots generated
            }
        }
    }

    private static void generateEntity() {

        Player.getInstance();

        GhostFactory.makeBlinky();
        GhostFactory.makePinky();
        GhostFactory.makeInky();
        GhostFactory.makeClyde();
    }

    private static void generateEnvironments() {

        new EmptyZone(ts * 7, ts * 9, ts * 14, ts * 11);
        new EmptyZone(1 * ts, 3 * ts, ts, ts);
        new EmptyZone(26 * ts, 3 * ts, ts, ts);
        new EmptyZone(1 * ts, 23 * ts, ts, ts);
        new EmptyZone(26 * ts, 23 * ts, ts, ts);
        new EmptyZone(26 * ts, 23 * ts, ts, ts);
        new EmptyZone(13 * ts, 23 * ts, ts * 2, ts);


        new Tunnel(0, ts * 14, 6 * ts, ts);
        new Tunnel(scrWidth - 6 * ts, ts * 14, 6 * ts, ts);

        //teleporters
        new Teleporter(-ts - (ts / 2), ts * 14,
                ScreenSettings.width - ts / 2, ts * 14);

        new Teleporter(ScreenSettings.width + (ts / 2), ts * 14,
                -(ts / 2), ts * 14);

    }

    public static void generateAll() {

        generateWalls();
        generateEnvironments();
        generateEntity();
        generateCollectables();
        Entity.list.add(new Mouse());

        Controller.allObjects.add(Environment.list);
        Controller.allObjects.add(Collectim.list);
        Controller.allObjects.add(Entity.list);
        new Button(ScreenSettings.width/2, ScreenSettings.height/2, Color.RED); //todo button
//        Controller.allObjects.add(TargetSign.list);//D🪲
    }
}
