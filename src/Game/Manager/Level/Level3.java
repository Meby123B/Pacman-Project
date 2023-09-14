
package Game.Manager.Level;

import Game.GameLoop;

public class Level3 implements Level{
    @Override
    public int getNum() {
        return 3;
    }

    @Override
    public void handleAiDifficulty() { //todo

    }

    @Override
    public double timeForBlueMode() {
        return 6.0;
    }

    @Override
    public double timeForFruit() {
        return 0.5;
    }

    @Override
    public double amountDotsForReleasingGhost() {
        return 6;
    }
}
