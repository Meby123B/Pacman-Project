package GameObject.Entity.Ai;

import GameObject.Entity.Ghost;
import GameObject.Entity.Player;

public class Blinky extends Ai{
    public Blinky(Ghost ghost) {
        super(ghost);
    }

    @Override
    public void setGoTo() {
        goToX = Player.getInstance().getX();
        goToY = Player.getInstance().getY();

    }
}
