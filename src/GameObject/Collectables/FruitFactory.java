package GameObject.Collectables;

import Animation.ImageTools;

public class FruitFactory {
    private static ImageTools imgTool = new ImageTools();

    public static Fruit makeChery(){
        Fruit fruit = new Fruit();
        fruit.setImage(imgTool.getImage("/Fruits/Chery.png"));
        fruit.setValue(100);
        return fruit;
    }
    public static Fruit makeStrawberry(){
        Fruit fruit = new Fruit();
        fruit.setImage(imgTool.getImage("/Fruits/Strawberry.png"));
        fruit.setValue(300);
        return fruit;
    }
    public static Fruit makeOrange(){
        Fruit fruit = new Fruit();
        fruit.setImage(imgTool.getImage("/Fruits/Orange.png"));
        fruit.setValue(500);
        return fruit;
    }
    public static Fruit makeApple(){
        Fruit fruit = new Fruit();
        fruit.setImage(imgTool.getImage("/Fruits/Apple.png"));
        fruit.setValue(700);
        return fruit;
    }
    public static Fruit makeMelon(){
        Fruit fruit = new Fruit();
        fruit.setImage(imgTool.getImage("/Fruits/Melon.png"));
        fruit.setValue(1000);
        return fruit;
    }

}
