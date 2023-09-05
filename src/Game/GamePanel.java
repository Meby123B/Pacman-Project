package Game;

import GameObject.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
//    Ghost ghost5 = new Ghost(ScreenSettings.tileSize * 20, ScreenSettings.tileSize * 14, Color.red);



    public GamePanel() {
        Generator.generateAll();
//        Controller.allObjects.add(ghost5);
//        Controller.ghosts.add(ghost5);

        this.setPreferredSize(new Dimension(ScreenSettings.width, ScreenSettings.height+50));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        while (gameThread != null) {
            GameLoop.loop(this);
        }
    }

    public void update() {
        Controller.updateAll();
//        ghost5.move(MoveSides.RIGHT);
//        Controller.allObjects.forEach(obj -> ghost5.checkCollision(obj));

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
//        ghost5.draw(g2);

        Controller.drawAll(g2);

        g2.dispose();
    }
}
