package Obj;

import UtilityAndResources.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Cloud{
    private BufferedImage cloudImage;
    private ArrayList<CloudChange> list;

    public Cloud(){
        cloudImage = Resource.getImage("pictures/cloud.png");
        list = new ArrayList<>();

        CloudChange cloud1 = new CloudChange();
        cloud1.positionHorizontal = 100;
        cloud1.positionVertical = 50;
        list.add(cloud1);

        CloudChange cloud2 = new CloudChange();
        cloud2.positionHorizontal = 200;
        cloud2.positionVertical = 30;
        list.add(cloud2);

        CloudChange cloud3 = new CloudChange();
        cloud3.positionHorizontal = 300;
        cloud3.positionVertical = 80;
        list.add(cloud3);

        CloudChange cloud4 = new CloudChange();
        cloud4.positionHorizontal = 450;
        cloud4.positionVertical = 50;
        list.add(cloud4);

        CloudChange cloud5 = new CloudChange();
        cloud5.positionHorizontal = 600;
        cloud5.positionVertical = 60;
        list.add(cloud5);
    }

    public void  cloudMoving(){
        for(CloudChange element : list){
            element.positionHorizontal -= 2;
        }
    }

    public void drawCloud(Graphics g){
        for(CloudChange element : list){
            g.drawImage(cloudImage, (int)element.positionHorizontal, (int)element.positionVertical, null);
        }
        CloudChange first = list.get(0);
        if(first.positionHorizontal + cloudImage.getWidth()< 0) {
            first.positionHorizontal = 600;
            list.add(first);
            list.remove(0);
        }
    }

    private class CloudChange{
        float positionHorizontal;
        float positionVertical;
    }
}
