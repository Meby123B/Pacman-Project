package Game;

public class ScreenSettings {
    final static int originalTileSize = 16;
    final static int scale = 2;
    public static final int tileSize = originalTileSize * scale;
    final static int maxScreenCol = 28;
    final static int maxScreenRow = 32;

    public static final int width = tileSize * maxScreenCol;
    public static final int height = tileSize * maxScreenRow;

}
