package Game.Manager;

import Game.ScreenSettings;

import java.awt.*;

public class Score {
    private static int amount = 0;
    public static int getScore() {
        return amount;
    }
    public static void increase(int addition) {
        amount += addition;
        System.out.println(amount); // D🪲
    }

    public static void reset() {
        amount = 0;
    }

    public static void draw(Graphics2D g2) {
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 20));
        g2.setPaint(Color.white);

        g2.drawString("Score: "+amount, 30, ScreenSettings.height+ScreenSettings.tileSize*2);
    }
}
