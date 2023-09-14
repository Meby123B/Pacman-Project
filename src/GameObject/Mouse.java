package GameObject;

import Game.Collision;
import Game.Controller;
import Game.ScreenSettings;
import GameObject.Collectables.Collectim;
import GameObject.Collectables.Dot;
import GameObject.Menues.Menu;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse extends GameObject implements MouseListener, MouseMotionListener {
    public static Mouse instance;
//    boolean press;
    MouseEvent event=null;

    public Mouse() {
        super(0, 0, Color.gray);

        this.height = 8;
        this.width = 8;
        instance = this;
    }
    private void updatePos(MouseEvent event){
        int ts = ScreenSettings.tileSize;
        if (event == null) {
            System.out.println("happen");
            return;
        }
        instance.setX(event.getX() - (int) (0.7 * ts));
        instance.setY(event.getY() - 2 * ts);

        System.out.println(instance.getX() / ts + "|" + instance.getY() / ts);//DBUG

    }
    private void checkMouse(boolean press){
        Menu.list.forEach(d -> {
            if (Collision.check((GameObject) d, instance)) {
                if (press) {
                    System.out.println("yeyyyyy");
                    d.whenClicked();
                } else {
                    d.whenMouseHover();
                }
            } else {
                d.whenMouseExit();
            }
        });
    }
    @Override
    public void update(){
//        updatePos();
//        checkMouse();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        event=e;
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        press =true;
        System.out.println("click");
        instance.setColor(Color.gray);
        checkMouse(true);

        event = e;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        press =false;
        event=e;
        instance.setColor(Color.darkGray);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        event=e;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        event=e;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        event=e;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        event=e;
        updatePos(event);
        checkMouse(false);
        int ts = ScreenSettings.tileSize;
//        System.out.println("MOVE");

//        instance.setX(e.getX() - (int) (0.7 * ts));
//        instance.setY(e.getY() - 2 * ts);
//
//        Menu.list.forEach(d -> {
//            if (Collision.check((GameObject) d, instance)) {
//                d.whenMouseHover();
//            } else {
//                d.whenMouseExit();
//            }
//        });

    }

//    @Override
//    public void draw(Graphics2D g2) {
//
//    }
}
