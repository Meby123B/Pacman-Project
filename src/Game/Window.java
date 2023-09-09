package Game;

import GameObject.Clickable;
import GameObject.Dot;
import GameObject.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Window implements MouseListener, MouseMotionListener {
    public void powerOn(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("PacMeby");
        window.addMouseListener(this);
        window.addMouseMotionListener(this);

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

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int ts = ScreenSettings.tileSize;
        System.out.println("click");
        Mouse.instance.setColor(Color.gray);
        Mouse.instance.setX(e.getX()-(int)(0.7*ts));
        Mouse.instance.setY(e.getY()-2*ts);
        Dot.list.forEach(d -> {
            if (d.checkCollision(Mouse.instance)){
                ((Clickable)d).whenClicked();
            }
        });
        System.out.println(e.getX()/ts+"|"+e.getY()/ts);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Mouse.instance.setColor(Color.darkGray);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int ts = ScreenSettings.tileSize;
        System.out.println("MOVE");
        Mouse.instance.setX(e.getX()-(int)(0.7*ts));
        Mouse.instance.setY(e.getY()-2*ts);
        Dot.list.forEach(d -> {
            if (d.checkCollision(Mouse.instance)){
                ((Clickable)d).whenClicked();
            }
        });
        System.out.println(e.getX()/ts+"|"+e.getY()/ts);

    }
}
