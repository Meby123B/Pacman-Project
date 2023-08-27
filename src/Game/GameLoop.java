package Game;


public class GameLoop {
    static private final int FPS = 60;
    static private final double  drawInterval = (double) 1000000000 /FPS;
    static private double delta = 0;
    static private long lastTime = System.nanoTime();
    static private long currentTime;

    public static void loop(GamePanel gp) {
        updateTimings();
        getOnceInFrame(gp);
    }

    private static void getOnceInFrame(GamePanel gp) {
        if (delta >= 1) {
            gp.update();
            gp.repaint();
            delta--;
        }
    }

    private static void updateTimings(){
        currentTime = System.nanoTime();
        delta += (currentTime -lastTime) / drawInterval;
        lastTime = currentTime;
    }

}
