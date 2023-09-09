package Game;

import GameObject.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;



    public GamePanel() {
        Generator.generateAll();

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

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        Drawer.drawAll(g2);

        g2.dispose();
    }
}
