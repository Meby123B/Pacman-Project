package GameObject;

import Game.ScreenSettings;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse extends GameObject implements MouseListener, MouseMotionListener {
    public static Mouse instance;
    public Mouse(){
        this.x=0;
        this.y=0;
        this.height=8;
        this.width=8;
//        this.color= Color.gray; //D🪲
        instance = this;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int ts = ScreenSettings.tileSize;
        System.out.println("click");
        instance.setColor(Color.gray);

        instance.setX(e.getX()-(int)(0.7*ts));
        instance.setY(e.getY()-2*ts);

        Dot.list.forEach(d -> {
            if (d.checkCollision(instance)){
                ((Clickable)d).whenClicked();
            }
        });
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        instance.setColor(Color.darkGray);

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

        instance.setX(e.getX()-(int)(0.7*ts));
        instance.setY(e.getY()-2*ts);

        Dot.list.forEach(d -> {
            if (d.checkCollision(instance)){
                ((Clickable)d).whenClicked();
            }
        });
//        System.out.println(e.getX()/ts+"|"+e.getY()/ts);DBUG

    }

//    @Override
//    public void draw(Graphics2D g2) {
//
//    }
}
