package GameObject.Collectables;

import Game.Manager.GameManager;
import Game.Manager.Timer;
import GameObject.Callable;

import java.awt.*;
import java.util.Random;

public class FruitFactory {

    public static Fruit makeChery(){
        Fruit fruit = new Fruit(new Color(0xDE3737));
        fruit.setValue(100);
        return fruit;
    }
    public static Fruit makeStrawberry(){
        Fruit fruit = new Fruit(new Color(0xFF0000));
        fruit.setValue(300);
        return fruit;
    }
    public static Fruit makeOrange(){
        Fruit fruit = new Fruit(new Color(0xFF7E00));
        fruit.setValue(500);
        return fruit;
    }
    public static Fruit makeApple(){
        Fruit fruit = new Fruit(new Color(0x00FF00));
        fruit.setValue(700);
        return fruit;
    }
    public static Fruit makeMellon(){
        Fruit fruit = new Fruit(new Color(0xFFFF31));
        fruit.setValue(1000);
        return fruit;
    }

}
