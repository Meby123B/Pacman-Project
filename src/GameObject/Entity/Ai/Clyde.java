package GameObject.Entity.Ai;

import Game.ScreenSettings;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;
import GameObject.Mouse;

public class Clyde extends Ai{
    public Clyde(Ghost ghost) {
        super(ghost);
    }

    @Override
    public void setGoTo() {
        int x = Player.getInstance().getX();
        int y = Player.getInstance().getY();

        int ts = ScreenSettings.tileSize;

        if (
            Math.abs(ghost.getX() - x) <8*ts
            && Math.abs(ghost.getY() - y) <8*ts
        ){
            //todo ?ScaterMode
            x = 0;
            y =  ScreenSettings.height;
        }
        Mouse.instance.setX(x);
        Mouse.instance.setY(y);

        goToX = x;
        goToY = y;
    }
}
