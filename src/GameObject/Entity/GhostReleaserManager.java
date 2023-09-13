package GameObject.Entity;

import Game.Manager.GameManager;
import Game.Manager.Timer;
import GameObject.Collectables.Collectim;

public class GhostReleaserManager {
     Ghost Pinky = (Ghost) Entity.list.get(2);
     Ghost Inky = (Ghost) Entity.list.get(3);
     Ghost Clyde = (Ghost) Entity.list.get(4);
     int dotAmount = Collectim.list.size();
     public boolean releasePinky, releaseInky, releaseClyde;
     Timer gapTimer = new Timer(Timer.secondToFrames(3));

    public void Check(){
        int sumForRelease = (int) (dotAmount / GameManager.getLevel().amountDotsForReleasingGhost());
        int eatenDots = dotAmount - Collectim.list.size();

        if (!gapTimer.timesUp()) return;
        if (eatenDots >= sumForRelease){
            releasePinky = true;
            gapTimer.reset();
        }

        if (!gapTimer.timesUp()) return;
        if (eatenDots >= sumForRelease*2){
            releaseInky = true;
            gapTimer.reset();
        }

        if (!gapTimer.timesUp()) return;
        if (eatenDots >= sumForRelease*3){
            releaseClyde = true;
            gapTimer.reset();
        }
    }
}
