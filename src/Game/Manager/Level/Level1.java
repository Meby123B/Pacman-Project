package Game.Manager.Level;

import Game.GameLoop;

public class Level1 implements Level{
    @Override
    public int getNum() {
        return 1;
    }

    @Override
    public void handleAiDifficulty() { //todo

    }

    @Override
    public double timeForBlueMode() {
        return 10.0;
    }

    @Override
    public double timeForFruit() {
        return 10.0;
    }
}
