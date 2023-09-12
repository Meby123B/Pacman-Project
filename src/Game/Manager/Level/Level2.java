
package Game.Manager.Level;

import Game.GameLoop;

public class Level2 implements Level{
    @Override
    public int getNum() {
        return 2;
    }

    @Override
    public void handleAiDifficulty() { //todo

    }

    @Override
    public double timeForBlueMode() {
        return 7.0;
    }

    @Override
    public double timeForFruit() {
        return 0.7;
    }
}
