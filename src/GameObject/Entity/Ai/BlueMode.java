package GameObject.Entity.Ai;

import GameObject.Entity.Ghost;
import GameObject.Entity.MoveSides;

public class BlueMode extends Ai{
    public BlueMode(Ghost ghost) {
        super(ghost);
    }

    @Override
    public void setGoTo() {

    }

    @Override
    public MoveSides getDirection(Ghost ghost) {
        return super.getRandomDir(ghost); //todo blueMode Ai
//        return null;
    }
}
