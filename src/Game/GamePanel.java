package Game;

import GameObject.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player();
    GameObject ghost = new Ghost();
    Dot dot = new Dot();
    Dot dot2 = new Dot();


    public GamePanel() {
        Controller.allObjects.add(player);
        Controller.allObjects.add(ghost);
        Controller.allObjects.add(dot);
        Controller.allObjects.add(dot2);
        Controller.allObjects.add(new Wall(0,0, 20, ScreenSettings.height));
        Controller.allObjects.add(new Wall(70,70, 20, ScreenSettings.height));



        this.setPreferredSize(new Dimension(ScreenSettings.width, ScreenSettings.height));
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
        player.update(keyH);

        Controller.updateAll(player);
        dot.move(MoveSides.RIGHT);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        Controller.drawAll(g2);

        g2.dispose();
    }
}
