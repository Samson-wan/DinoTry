package Obj;

import UtilityAndResources.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cactus {
    private BufferedImage CactusImage;
    private float positionHorizontal;
    private float positionVertical;

    public Cactus(){
        CactusImage = Resource.getImage("pictures/cactus1.png");
        positionHorizontal = 200;
        positionVertical = 65;
    }

    public void moveCactus(){
        positionHorizontal -= 2;
    }

    public void drawCactus(Graphics g){
        g.drawImage(CactusImage, (int)positionHorizontal, (int)positionVertical, null);
    }

}
