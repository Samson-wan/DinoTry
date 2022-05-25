package Interaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import Obj.Cactus;
import Obj.Dinosaur;
import Obj.Ground;

public class GamePanel extends JPanel implements Runnable, KeyListener { //https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html
    private static Thread thread;
    public static final float GRAVITY = 0.1f; //add suffix f to make it identify as a float
    public static final float GROUNDY = 500;
    private Dinosaur dino;
    private Ground ground;
    private Cactus cactusGroup1;
    private Cactus cactusGroup2;
    private JFrame frame;

    public GamePanel(JFrame frame){
        thread = new Thread(this);
        dino = new Dinosaur();
        this.frame = frame;
        ground = new Ground(frame);
        cactusGroup1 = new Cactus(frame);
        cactusGroup2 = new Cactus(frame);
    }

    public static void activate(){
        thread.start();
    }
    @Override
    public void run() {
        while(true){
            try{
                dino.changePosition();
                repaint(); //call the paint method again after the x and y coordinate has been changed
                Thread.sleep(20);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g){ //https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.drawLine(0, (int)GROUNDY, getWidth(), (int)GROUNDY);
        ground.drawGround(g); //draw ground
        dino.drawObj(g); //draw dino
        cactusGroup1.drawCactus(g); //draw cactus;
        cactusGroup2.drawCactus(g);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        dino.dinoJump();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KeyReleased");
    }
}
