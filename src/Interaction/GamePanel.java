package Interaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import Obj.Dinosaur;

public class GamePanel extends JPanel implements Runnable, KeyListener { //https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html
    private static Thread thread;
    public static final float GRAVITY = 0.1f; //add suffix f to make it identify as a float
    public static final float GROUNDY = 300;
    private Dinosaur dino;

    public GamePanel(){
        thread = new Thread(this);
        dino = new Dinosaur();
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
        dino.drawObj(g);
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
