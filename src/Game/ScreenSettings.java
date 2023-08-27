package Game;

public class ScreenSettings {
    final int originalTileSize = 16;
    final int scale = 1;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 28;
    final int maxScreenRow = 32;

    final int width = tileSize * maxScreenCol;
    final int height = tileSize * maxScreenRow;

}
