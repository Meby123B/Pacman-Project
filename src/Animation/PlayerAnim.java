package Animation;

import GameObject.Entity.MoveSides;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayerAnim {

    public BufferedImage[] leftAnimation = new BufferedImage[3];
    public BufferedImage[] upAnimation = new BufferedImage[3];
    public BufferedImage[] rightAnimation = new BufferedImage[3];
    public BufferedImage[] downAnimation = new BufferedImage[3];
    MoveSides lastDirection= MoveSides.LEFT;
    int frameCounter=0;
    public void updateFrameCounter(){
        frameCounter++;
    }

    public void getImages(){
        try {
            for (int i = 0; i < 3; i++) {
                leftAnimation[i] = ImageIO.read(getClass().getResourceAsStream("/Player/PacLeft"+(i+1)+".png"));
                upAnimation[i] = ImageIO.read(getClass().getResourceAsStream("/Player/PacUp"+(i+1)+".png"));
                rightAnimation[i] = ImageIO.read(getClass().getResourceAsStream("/Player/PacRight"+(i+1)+".png"));
                downAnimation[i] = ImageIO.read(getClass().getResourceAsStream("/Player/PacDown"+(i+1)+".png"));
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public BufferedImage drawPlayer(Graphics2D g2, MoveSides direction){
        if (direction == null) {
            frameCounter=0;
            direction = lastDirection;
        } else {
            lastDirection = direction;
        }

        BufferedImage[] pointer = new BufferedImage[0];
        switch (direction){
            case LEFT -> pointer = leftAnimation;
            case UP -> pointer = upAnimation;
            case RIGHT -> pointer = rightAnimation;
            case DOWN -> pointer = downAnimation;
        }

        switch ((frameCounter/3)%4){
            case 0 -> {return pointer[0];}
            case 1 -> {return pointer[1];}
            case 2 -> {return pointer[2];}
            case 3 -> {return pointer[1];}
        }
        return null;
    }
}
