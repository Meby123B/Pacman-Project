package GameObject;

public interface Movable {

    void move(MoveSides dir);
    void changeDirection(MoveSides dir);
    int getSpeed();
    MoveSides getDirection();
    void setDirection(MoveSides dir);
}
