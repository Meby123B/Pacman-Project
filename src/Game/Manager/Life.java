package Game.Manager;

import Game.ScreenSettings;

import java.awt.*;

public class Life {
    private static int amount = 3;
    public static int getLife() {
        return amount;
    }
    public  void _1Up() {
        amount += 1;
//        System.out.println(amount); // D🪲
    }
    public static void lose() {
        amount -= 1;
//        System.out.println(amount); // D🪲
    }

    public static void reset() {
        amount = 3;
    }

    public static void draw(Graphics2D g2) {
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 20));
        g2.setPaint(Color.YELLOW);

        switch (amount){
            case 5:
                g2.drawString("0", 380, ScreenSettings.height+ScreenSettings.tileSize*2);
            case 4:
                g2.drawString("0", 360, ScreenSettings.height+ScreenSettings.tileSize*2);
            case 3:
                g2.drawString("0", 340, ScreenSettings.height+ScreenSettings.tileSize*2);
            case 2:
                g2.drawString("0", 320, ScreenSettings.height+ScreenSettings.tileSize*2);
            case 1:
                g2.drawString("0", 300, ScreenSettings.height+ScreenSettings.tileSize*2);
        }
    }
}
