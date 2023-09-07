package Game;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window implements MouseListener {
    public void powerOn(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("PacMeby");
        window.addMouseListener(this);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

//        g gameloop = new GameLoop(player);
        gamePanel.startGameThread();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
        System.out.println(e.getX()/ScreenSettings.tileSize+"|"+e.getY()/ScreenSettings.tileSize);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
