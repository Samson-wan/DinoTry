package Obj;

import UtilityAndResources.Animation;
import UtilityAndResources.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

import static Interaction.GamePanel.GRAVITY;
import static Interaction.GamePanel.GROUNDY;


public class Dinosaur {
    private float x = 0;
    private float y = 0;
    private float speedVertical = 0;
    private Animation object;
    private Rectangle rect;
    private boolean survive = true;

    public Dinosaur(){
        object = new Animation(200);
        object.addFrame(Resource.getImage("pictures/main-character1.png"));
        object.addFrame(Resource.getImage("pictures/main-character2.png"));
        rect = new Rectangle();
    }

    public void changePosition(){ //Belongs to dinoJump - change in dino's vertical position
        object.update();
        if(y >= GROUNDY - object.getFrames().getHeight()){
            speedVertical = 0;
            y = GROUNDY - object.getFrames().getHeight();
        }
        else{
            speedVertical += GRAVITY; // speed increase as time increases
            y += speedVertical;
        }
        rect.x = (int)x;
        rect.y = (int)y;
        rect.width = object.getFrames().getWidth();
        rect.height = object.getFrames().getHeight();
    }

    public Rectangle getRect(){
        return rect;
    }

    public void dinoJump(){
        speedVertical -= 4;
        y += speedVertical;
    }

    public void drawObj(Graphics g){
        g.setColor(Color.black);
//        g.drawRect((int)x, (int)y, object.getFrames().getWidth(), object.getFrames().getHeight());
        g.drawImage(object.getFrames(), (int)x, (int)y, null);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setSpeedVertical(float speedVertical) {
        this.speedVertical = speedVertical;
    }

    public void setSurvive(boolean survive) {
        this.survive = survive;
    }

    public boolean survive(){
        return survive;
    }
}
