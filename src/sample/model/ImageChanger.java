package sample.model;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Arek on 21.01.2017.
 */
public class ImageChanger {
    private PixelChanger pixelChanger;
    private BufferedImage image;
    private FileHandler fileHandler;

    public void setPixelChanger(PixelChanger pixelChanger) {
        this.pixelChanger = pixelChanger;
    }

    public void setFileHandler(FileHandler handler) {
        this.fileHandler = handler;
    }

    public void convertImage(String input, String output) throws IOException {
        image = fileHandler.openFile(input);
        changeEveryPixel();
        fileHandler.saveFile(output, image);
    }

    private void changeEveryPixel() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        int rgb;

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                rgb = image.getRGB(j, i);
                rgb = pixelChanger.changePixel(rgb);
                image.setRGB(j, i, rgb);
            }
        }

    }


}
