package Game;

public class ScreenSettings {
    final int originalTileSize = 16;
    final int scale = 1;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 28;
    final int maxScreenRow = 32;

    public final int width = tileSize * maxScreenCol;
    public final int height = tileSize * maxScreenRow;

}
