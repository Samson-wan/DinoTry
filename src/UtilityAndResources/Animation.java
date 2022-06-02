package UtilityAndResources;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


//I don't really know how to do this, I went online for source code
public class Animation { //switch image while dino is running
    private List<BufferedImage> frames;
    private int frameIndex = 0;
    private int timeInterval;
    private long previousTime;


    public Animation(int timeInterval){
        frames = new ArrayList<BufferedImage>();
        this.timeInterval = timeInterval;
    }

    public void update(){
        if(System.currentTimeMillis() - previousTime > timeInterval) {
            frameIndex++;
            if (frameIndex >= frames.size()) {
                frameIndex = 0;
            }
            previousTime = System.currentTimeMillis();
        }
    }

    public void addFrame(BufferedImage frame){
        frames.add(frame);
    }

    public BufferedImage getFrames() {
        if(frames.size() > 0){
            return frames.get(frameIndex);
        }
        return null;
    }
}
