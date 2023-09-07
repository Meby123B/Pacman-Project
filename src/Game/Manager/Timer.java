package Game.Manager;

import Game.GameLoop;
import GameObject.GameObject;

import java.util.ArrayList;

public class Timer {
    public static ArrayList<GameObject> list = new ArrayList<>();

    private int count;
    private boolean pause = false;
    public Timer(double timeToCount) {
        this.count = (int) (timeToCount * GameLoop.FPS);
    }
    public int timeLeft() {
        return count;
    }
    public boolean timesUp() {
        return count <= 0;
    }
    public void countDown() {
        if (pause) return;

        count--;
    }
    public void pause() {
        this.pause = true;
    }
    public void resume() {
        this.pause = false;
    }

}
