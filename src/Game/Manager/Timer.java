package Game.Manager;

import Game.Controller;
import Game.GameLoop;
import GameObject.Callable;

import java.util.ArrayList;

public class Timer {
    public static ArrayList<Timer> list = new ArrayList<>();

    private int count;
    private int startCount;
    private String name;
    private Callable callAtEnd;
    private boolean pause = false;

    public Timer(int frames) {
        startCount = frames;
        this.count = frames;
        list.add(this);
    }
    public Timer(int frames, Callable callback) {
        startCount = frames;
        this.count = frames;
        this.callAtEnd = callback;
        list.add(this);
    }
    public static int secondToFrames(double seconds){
        return (int) (seconds * GameLoop.FPS);
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
            pause();
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
    public void reset() {
        this.count = startCount;
        resume();
    }
    public void addTime(int frames) {
        this.count += frames;
    }

}
