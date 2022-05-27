package Obj;

import UtilityAndResources.Resource;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cactus extends Obstacle{
    private BufferedImage cactusImage;
    private float positionHorizontal;
    private float positionVertical;
    private Rectangle rect; //hitbox of the cactus
    private Dinosaur dino;
    private boolean isScoreGot = false;

    public Cactus(Dinosaur dino){
        this.dino = dino;
        cactusImage = Resource.getImage("pictures/cactus1.png");
        positionHorizontal = 200;
        positionVertical = 65;
        rect = new Rectangle();
    }

    //overRide
    public void moveCactus(){
        positionHorizontal -= 2;
        rect.x = (int)positionHorizontal;
        rect.y = (int)positionVertical;
        rect.width = cactusImage.getWidth();
        rect.height = cactusImage.getHeight();
    }

    public Rectangle getRect(){
        return rect;
    }

    //overRide
    public void drawCactus(Graphics g){
        g.drawImage(cactusImage, (int)positionHorizontal, (int)positionVertical, null);
    }

    public void setCactusImage(BufferedImage cactusImage) {
        this.cactusImage = cactusImage;
    }

    public void setPositionHorizontal(float positionHorizontal) {
        this.positionHorizontal = positionHorizontal;
    }

    public void setPositionVertical(float positionVertical) {
        this.positionVertical = positionVertical;
    }

    public boolean isOut(){
        return(positionHorizontal + cactusImage.getWidth() < 0);
    }

    public boolean isGameOver(){
        return dino.getX() > positionHorizontal;
    }

    public boolean isScoreGot(){
        return isScoreGot;
    }

    public void setScoreGot(boolean scoreGot){
        isScoreGot = scoreGot;
    }
}
