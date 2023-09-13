package GameObject.Entity;

import Animation.ImageTools;
import Game.Manager.GameManager;
import Game.Manager.Mode.BlueMode;
import Game.Manager.Mode.Mode;
import Game.Manager.Mode.NormalMode;
import Game.Manager.Score;
import Game.ScreenSettings;
import GameObject.Eatable;
import GameObject.Entity.Ai.Ai;
import GameObject.Movable;
//import GameObject.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ghost extends GameObject.GameObject implements Movable, Eatable {
//    public boolean isEaten=false;
    boolean getOut= false;
    Mode mode = new NormalMode();


    Ai ai;
    MoveSides direction=null;
    BufferedImage image;

    public Ghost(int x, int y, String path){

        super(x,y);
        super.setOriginalPos(x,y);
        image = new ImageTools().getImage(path);
        Entity.list.add(this);
    }

    public void setAi(Ai ai) {
        this.ai = ai;
    }

    @Override
    public void update() {
        direction = mode.getGhostAi(this).getDirection(this);

        if (getOut){
            exit();
        }
        move(direction);
    }
    public void collideWithPlayer(Player p){
        mode.whenGhostEaten(this).whenEaten();
    }

    @Override
    public void move(MoveSides dir) {
        Movement.moveObject(this,dir);
    }

    @Override
    public void changeDirection(MoveSides dir) {}

    @Override
    public int getSpeed() {
        return mode.ghostSpeed(this);
    }

    @Override
    public MoveSides getDirection() {
        return direction;
    }

    @Override
    public void setDirection(MoveSides dir) {
        this.direction = dir;
    }

    @Override
    public void whenEaten() {
        setDirection(null);
        Score.increase(200);
        mode = new NormalMode();
        getOut=true;
        this.resetPosition();
    }

    public void exit() {
        if (y <= ScreenSettings.tileSize *11) {
            getOut = false;
            return;
        }

        Movement.moveThroughWall(this, MoveSides.UP);
    }

    public void setOut() {
        this.getOut = true;
    }

    @Override
    public void draw(Graphics2D g2) {
        int ts = ScreenSettings.tileSize;
        BufferedImage imageByMode = mode.getGhostImage(this);
        g2.drawImage(imageByMode, x-ts/4, y-ts/4,width+ts/2,height+ts/2, null);

//        g2.setColor(GameManager.getGameMode()
//                .getGhostColor(this));
//        g2.fillRect(x,y,width,height);
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public Ai getAi() {
        return this.ai;
    }
    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }
}
