package UtilityAndResources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Resource { //https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
    public static BufferedImage getImage(String directory){ //compress the image into 8 bit
        BufferedImage image = null;
        try{
            image = ImageIO.read(new File(directory));//Grab the image in the picture folder of my project
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
