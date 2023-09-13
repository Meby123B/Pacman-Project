package Animation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageTools {
    public BufferedImage getImage(String path){
        BufferedImage image=null;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));

        }catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
