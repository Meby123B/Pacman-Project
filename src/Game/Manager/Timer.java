package Game.Manager;

import Game.Controller;
import Game.GameLoop;
import GameObject.Callable;

import java.util.ArrayList;

public class Timer {
    public static ArrayList<Timer> list = new ArrayList<>();

    private int count;
    private String name;
    private Callable callAtEnd;
    private boolean pause = false;

    public Timer(int frames) {
        this.count = frames;
        list.add(this);
    }
    public Timer(double seconds) {
        this.count = (int) (seconds * GameLoop.FPS);
        list.add(this);
    }
    public Timer(double seconds, Callable callback) {
        this.count = (int) (seconds * GameLoop.FPS);
        this.callAtEnd = callback;
        list.add(this);
    }
    public Timer(int frames, Callable callback) {
        this.count = frames;
        this.callAtEnd = callback;
        list.add(this);
    }

    public int timeLeft() {
        return count;
    }

    public boolean timesUp() {
        return count <= 0;
    }
    public void countDown() {
        if (pause) return;
        System.out.println(count);

        if (timesUp() && callAtEnd != null) {
            callAtEnd.callBack();
            Controller.removeTimer(this);
            return;
        }

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
