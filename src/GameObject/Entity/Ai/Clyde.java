package GameObject.Entity.Ai;

import Game.ScreenSettings;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;
import GameObject.Mouse;

public class Clyde extends Ai{
    public Clyde(Ghost ghost) {
        super(ghost);
        setTarget();

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

        goToX = x;
        goToY = y;
        updateTargetPosition();

    }
}
