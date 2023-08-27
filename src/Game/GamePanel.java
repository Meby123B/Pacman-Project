package Game;

import Elements.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player();
    ScreenSettings screenSettings = new ScreenSettings();
    public GamePanel() {

        this.setPreferredSize(new Dimension(screenSettings.width, screenSettings.height));
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
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
        g2.dispose();
    }
}
