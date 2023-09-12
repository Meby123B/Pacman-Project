package Game;

public class ScreenSettings {
    final static int originalTileSize = 16;
    public final static double scale = 1;
    public static final int tileSize = (int) (originalTileSize * scale);
    public final static int maxScreenCol = 28;
    public final static int maxScreenRow = 31;

    public static final int width = tileSize * maxScreenCol;
    public static final int height = tileSize * maxScreenRow;

}
