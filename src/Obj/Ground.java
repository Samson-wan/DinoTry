package Obj;

import UtilityAndResources.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

import static Interaction.GamePanel.GROUNDY;

public class Ground {
    private List<groundImages> imagesList;
    private BufferedImage imageGround1;
    private BufferedImage imageGround2;
    private BufferedImage imageGround3;

    public Ground(){
        imageGround1 = Resource.getImage("pictures/land1.png");
        imageGround1 = Resource.getImage("pictures/land2.png");
        imageGround1 = Resource.getImage("pictures/land3.png");
        imagesList = new List<groundImages>();
        for(int i = 0; i < 5; i++){
            groundImages images = new groundImages();
            images = i * imageGround1.getWidth();

        }
    }
    public void drawGround(Graphics g){
        g.drawImage(imageGround1, 50, (int)GROUNDY - 15, null);
    }

    private class groundImages{
        int positionHorizontal;
        BufferedImage image;
    }
}
