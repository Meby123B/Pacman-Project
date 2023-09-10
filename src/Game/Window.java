package Game;

import GameObject.Mouse;

import javax.swing.*;

public class Window  {
    public void powerOn(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("PacMeby");

        Mouse mouse = new Mouse();
        window.addMouseListener(mouse);
        window.addMouseMotionListener(mouse);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

//        g gameloop = new GameLoop(player);
        gamePanel.startGameThread();

    }

}
