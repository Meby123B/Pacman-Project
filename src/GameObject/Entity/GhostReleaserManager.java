package GameObject.Entity;

import Game.Manager.GameManager;
import Game.Manager.Timer;
import GameObject.Collectables.Collectim;
import GameObject.Entity.Ai.Blinky;

public class GhostReleaserManager {
     static Ghost Pinky = (Ghost) Entity.list.get(2);
     static Ghost Inky = (Ghost) Entity.list.get(3);
     static Ghost Clyde = (Ghost) Entity.list.get(4);
     static int dotAmount = Collectim.list.size();
     static public boolean releasePinky, releaseInky, releaseClyde;
     static Timer gapTimer = new Timer(Timer.secondToFrames(3));

    public static void check(){
        int sumForRelease = (int) (dotAmount / GameManager.getLevel().amountDotsForReleasingGhost());
        int eatenDots = dotAmount - Collectim.list.size();

        System.out.println(eatenDots);

        if (!gapTimer.timesUp()) return;
        if ((!releasePinky) && eatenDots >= sumForRelease){
            System.out.println("pinky");
            releasePinky = true;
            Pinky.setOut();
            gapTimer.reset();
        }

        if (!gapTimer.timesUp()) return;
        if ((!releaseInky) && eatenDots >= sumForRelease*2){
            System.out.println("inky");

            releaseInky = true;
            Inky.setOut();
            gapTimer.reset();
        }

        if (!gapTimer.timesUp()) return;
        if ((!releaseClyde) && eatenDots >= sumForRelease*3){
            System.out.println("clyde");

            releaseClyde = true;
            Clyde.setOut();
            gapTimer.reset();
        }
    }
    public static void setAllUnrealesde(){
        Pinky.getOut = false;
        gapTimer.reset();
        releaseClyde = releaseInky = releasePinky = false;
    }


}
