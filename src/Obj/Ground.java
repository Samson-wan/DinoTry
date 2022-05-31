package Obj;

import Interaction.GamePanel;
import UtilityAndResources.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

import static Interaction.GamePanel.GROUNDY;

public class Ground {
    private ArrayList<groundImage> imagesList;
    private BufferedImage imageGround1;
    private BufferedImage imageGround2;
    private BufferedImage imageGround3;

    public Ground(GamePanel panel){
        imageGround1 = Resource.getImage("pictures/land1.png");
        imageGround2 = Resource.getImage("pictures/land2.png");
        imageGround3 = Resource.getImage("pictures/land3.png");
        imagesList = new ArrayList<groundImage>();
        int panelWidth = 600;
        int groundNum = panelWidth / imageGround1.getWidth() + 2;
        for(int i = 0; i < groundNum; i++){
            groundImage images = new groundImage();
            images.positionHorizontal = (int)i * imageGround1.getWidth();
            images.image = getRandomImage();
            imagesList.add(images);
        }
    }

    public BufferedImage getRandomImage(){
        int num = (int)(Math.random() * 10);
        BufferedImage imageReturn = null;
        if(num == 1){
            imageReturn = imageGround1;
        }
        else if(num == 9){
            imageReturn = imageGround3;
        }
        else{
            imageReturn = imageGround2;
        }
        return imageReturn;
    }

    public void landMoving(int changeSpeed){
        for(groundImage element : imagesList){
            element.positionHorizontal -= changeSpeed; //Move ground left to make Dino looks like running
        }
        groundImage first = imagesList.get(0);
        if(first.positionHorizontal + imageGround1.getWidth()< 0){ //Move first ground to the end to make it appear again.
            first.positionHorizontal = imagesList.get(imagesList.size() - 1).positionHorizontal + imageGround1.getWidth();
            imagesList.add(first);
            imagesList.remove(0);
        }
    }
    public void drawGround(Graphics g){
        for(groundImage element : imagesList) {
            g.drawImage(element.image, element.positionHorizontal, (int) GROUNDY - 20, null);
        }
    }

    private class groundImage{ //help change land position;
        int positionHorizontal;
        BufferedImage image;
    }
}
