package Game.Manager;

import Game.GameLoop;
import GameObject.GameObject;

import java.util.ArrayList;

public class Timer {
    public static ArrayList<Timer> list = new ArrayList<>();

    private int count;
    private boolean pause = false;
    public Timer(double seconds) {
        this.count = (int) (seconds * GameLoop.FPS);
        list.add(this);
    }
    public Timer(int frames) {
        this.count = frames;
        list.add(this);
    }
    public int timeLeft() {
        return count;
    }
    public boolean timesUp() {
        return count <= 0;
    }
    public void countDown() {
        if (pause || timesUp()) return;

        count--;
    }
    public void pause() {
        this.pause = true;
    }
    public void resume() {
        this.pause = false;
    }
    public void delete() {
        list.remove(this);
    }

}
