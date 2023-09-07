package Game;


public class GameLoop {
    static public final int FPS = 60;
    static private final double  drawInterval = (double) 1000000000 /FPS;
    static private double delta = 0;
    static private long lastTime = System.nanoTime();
    static private long currentTime;
    static private int waitFor = 0;

    public static void loop(GamePanel gp) {
        updateTimings();
        getOnceInFrame(gp);
    }

    private static void getOnceInFrame(GamePanel gp) {
        if (delta >= 1) {
            if (waitFor <= 0){

            gp.update();
            gp.repaint();
            }else {
                waitFor--;
            }
            delta--;
        }
    }

    private static void updateTimings(){
        currentTime = System.nanoTime();
        delta += (currentTime -lastTime) / drawInterval;
        lastTime = currentTime;
    }
    public static void waitFrames(int numOfFrames){
        waitFor = numOfFrames;
    }

        }
