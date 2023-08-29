package Game;

import GameObject.Dot;
import GameObject.MoveSides;
import GameObject.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player();
    Dot dot = new Dot();
    public GamePanel() {

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
        player.checkCollision(dot);
        dot.move(MoveSides.RIGHT);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        player.draw(g2);
        dot.draw(g2);

        g2.dispose();
    }
}
