package sample.model;

/**
 * Created by Arek on 21.01.2017.
 */
public class Sepia implements PixelChanger {
   private float redRed = 0.393f;
    private float greenRed = 0.769f;
    private float blueRed = 0.189f;
    private float redGreen = 0.349f;
    private float greenGreen = 0.686f;
    private float blueGreen = 0.168f;
    private float redBlue = 0.272f;
    private float greenBlue = 0.534f;
    private float blueBlue = 0.131f;


    @Override
    public int changePixel(int pixel) {
        int transparency = (pixel >> TRANSPARENCY_BITS) & MASK;
        int red = (pixel >> RED_BITS) & MASK;
        int green = (pixel >> GREEN_BITS) & MASK;
        int blue = pixel & MASK;

        int newRed = (int)(red*redRed + green*greenRed + blue*blueRed );
        int newGreen = (int)(red*redGreen + green*greenGreen + blue*blueGreen );
        int newBlue = (int)(red*redBlue + green*greenBlue + blue*blueBlue );

        newRed = check(newRed);
        newGreen = check(newGreen);
        newBlue = check(newBlue);

        pixel = (transparency << TRANSPARENCY_BITS) | (newRed << RED_BITS) |
                (newGreen << GREEN_BITS) | newBlue;

        return pixel;
    }

    private int check(int newColor) {
        return (newColor > 255)? 255 : newColor;
    }
}
