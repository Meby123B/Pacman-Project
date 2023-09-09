
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
    public int timeForBlueMode() {
        return GameLoop.FPS * 7;
    }

    @Override
    public int timeForFruit() {
        return GameLoop.FPS * 7;
    }
}
