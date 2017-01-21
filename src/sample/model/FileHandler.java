package sample.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Arek on 21.01.2017.
 */
public class FileHandler {

    public BufferedImage openFile(String input) throws IOException {
        BufferedImage image;
        File file = new File(input);
        image = ImageIO.read(file);
        return image;
    }
    public void saveFile(String fileName, BufferedImage content) throws IOException {
        File file = new File(fileName);
        ImageIO.write(content, "jpg", file);
    }
}
