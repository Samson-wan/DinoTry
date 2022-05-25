package Obj;

import UtilityAndResources.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

import static Interaction.GamePanel.GROUNDY;

public class Cactus {
    private ArrayList<BufferedImage> cactusList;
    private float xCoord = 0;
    private BufferedImage cactus1;
    private BufferedImage cactus2;
    private JFrame frame;

    public Cactus(JFrame frame){
        cactus1 = Resource.getImage("pictures/cactus1.png");
        cactus2 = Resource.getImage("pictures/cactus2.png");
        this.frame = frame;
        xCoord = frame.getWidth();
        cactusList = new ArrayList<BufferedImage>();
        cactusList.add(cactus1);
        cactusList.add(cactus2);
    }

    public void drawCactus(Graphics g) {
        xCoord -= 10;
//        int currentCactusIndex = (int)(Math.random() * 2);
//        int nextCactusIndex = (int)(Math.random() * 2);
        //int gap = (int)(Math.random() * 150) + 250;
        BufferedImage currentCactus = cactusList.get(0);
        BufferedImage nextCactursIndex = cactusList.get(1);
        g.drawImage(currentCactus, (int)xCoord, (int)GROUNDY - 30, null);
        g.drawImage(nextCactursIndex, (int)xCoord + 25, (int)GROUNDY - 20, null);
    }
}
