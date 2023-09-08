
package Game.Manager.Level;

import Game.GameLoop;

public class Level3 implements Level{
    @Override
    public int getNum() {
        return 1;
    }

    @Override
    public void handleAiDifficulty() { //todo

    }

    @Override
    public int timeForBlueMode() {
        return GameLoop.FPS * 5;
    }

    @Override
    public int timeForFruit() {
        return GameLoop.FPS * 5;
    }
}
