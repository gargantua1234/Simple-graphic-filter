package sample.model;

/**
 * Created by Arek on 21.01.2017.
 */
public class Negative implements PixelChanger {

    @Override
    public int changePixel(int pixel) {
        int transparency = (pixel >> TRANSPARENCY_BITS) & MASK;
        int red = (pixel >> RED_BITS) & MASK;
        int green = (pixel >> GREEN_BITS) & MASK;
        int blue = pixel & MASK;

        int newRed = 255 - red;
        int newGreen = 255 - green;
        int newBlue = 255 - blue;

        pixel = (transparency << TRANSPARENCY_BITS) | (newRed << RED_BITS) |
                (newGreen << GREEN_BITS) | newBlue;

        return pixel;
    }
}
