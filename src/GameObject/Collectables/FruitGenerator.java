package GameObject.Collectables;

import Game.Manager.Timer;

import java.util.Random;

public class FruitGenerator {
    private static Random random = new Random();
    private static int timeInSeconds = Timer.secondToFrames(
            random.nextInt(5,15)
    );
    private static Timer timer = new Timer(timeInSeconds);

    private static void createFruit() {
        int i = random.nextInt(0,5);

        switch (i){
            case 0 -> FruitFactory.makeChery();
            case 1 -> FruitFactory.makeStrawberry();
            case 2 -> FruitFactory.makeOrange();
            case 3 -> FruitFactory.makeApple();
            case 4 -> FruitFactory.makeMellon();
        }
    }

    public static void checkForGenerate() {
        if (timer.timesUp()){
            createFruit();
            timer.reset();
        }
    }
}
