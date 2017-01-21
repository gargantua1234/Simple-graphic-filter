package sample.model;

/**
 * Created by Arek on 21.01.2017.
 */
public interface PixelChanger {
    int MASK = 0xff;
    int TRANSPARENCY_BITS = 24;
    int RED_BITS = 16;
    short GREEN_BITS = 8;

    int changePixel(int pixel);


}
