package GameObject;

import java.awt.*;

import static Game.ScreenSettings.tileSize;

public abstract class GameObject {
    protected int x,y;
    int width = tileSize;
    int height = tileSize;
    Color color = Color.GRAY;

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x,y,width,height);
    }
    public int getLeft(){ return x;}
    public int getRight(){ return x+width-1;}
    public int getUp(){ return y;}
    public int getDown(){ return y+ height-1;}

    public int getX() {
        return x;
    }
    public void setX(int newX) {
        x = newX;
    }
    public int getY() {
        return y;
    }
    public void setY(int newY) {
        this.y = newY;
    }
    public void getColor(Color newColor){ color = newColor;}
    public Color getColor(){return color;}
    public abstract void collideWithPlayer(Player p);
    public abstract void collideWithGhost(Ghost g);



    public boolean checkCollision(GameObject other){
        if (
            getUp() <= other.getDown()
            && getDown() >= other.getUp()
            && getLeft() <= other.getRight()
            && getRight() >= other.getLeft()
        ){
            if (this instanceof Player){
                other.collideWithPlayer((Player)this);

            } else if (this instanceof Ghost){
                other.collideWithGhost((Ghost)this);
            }
            return true;
        }
        return false;
    }

    public boolean isCollideWithWall(){
        for (int i = 0; i < Wall.list.size(); i++) {

            if(checkCollision(Wall.list.get(i))){
                return true;
            }
        }
        return false;
    }


}
