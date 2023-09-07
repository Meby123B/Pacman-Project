
package Game.Manager.Level;

import Game.GameLoop;

public class Level2 implements Level{
    @Override
    public int getNum() {
        return 1;
    }

    @Override
    public void handleAiDifficult() { //todo

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
