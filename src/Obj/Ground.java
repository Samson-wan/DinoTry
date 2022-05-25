package Obj;

import Interaction.GameWindow;
import UtilityAndResources.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static Interaction.GamePanel.GROUNDY;

public class Ground {
    private ArrayList<BufferedImage> imageList;
    private BufferedImage imageGround1;
    private BufferedImage imageGround2;
    private BufferedImage imageGround3;
    private JFrame frame;

    public Ground(JFrame frame){
        imageGround1 = Resource.getImage("pictures/land1.png");
        imageGround2 = Resource.getImage("pictures/land2.png");
        imageGround3 = Resource.getImage("pictures/land3.png");
        imageList = new ArrayList<BufferedImage>();
        this.frame = frame;
        imageList.add(imageGround1);
        imageList.add(imageGround2);
        imageList.add(imageGround3);
    }

    public void drawGround(Graphics g) {
        int index = 0;
        while(50 * index < frame.getWidth()) {
            for (int i = 0; i < imageList.size(); i++) {
                g.drawImage(imageList.get(i), 50 * index, (int) GROUNDY - 15, null);
                index++;
            }
        }
    }
}