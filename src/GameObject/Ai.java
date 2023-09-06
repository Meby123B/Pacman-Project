package GameObject;

import GameObject.Entity.MoveSides;

import java.util.Random;

public class Ai {
    public static MoveSides getDirection() {
        MoveSides newDir = null;

        Random rand = new Random();
        switch (rand.nextInt(4)){
            case 0 -> newDir = MoveSides.LEFT;
            case 1 -> newDir = MoveSides.DOWN;
            case 2 -> newDir = MoveSides.UP;
            case 3 -> newDir = MoveSides.RIGHT;
        }

        return newDir;
    }
}
