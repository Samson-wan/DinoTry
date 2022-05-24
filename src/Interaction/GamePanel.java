package Interaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable, KeyListener { //https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html
    private static Thread thread;
    private static final float GRAVITY = 0.1f;
    private static final float GROUNDY = 300; //pixel
    private float x = 0;
    private float y = 0;
    private float speedHorizontal = 0;
    private float speedVertical = 0;

    public GamePanel(){
        thread = new Thread(this);
    }

    public static void activate(){
        thread.start();
    }
    @Override
    public void run() {
        while(true){
            try{
                if(y >= GROUNDY - 100){
                    speedVertical = 0;
                    y = GROUNDY - 100;
                }
                else{
                    speedVertical += GRAVITY; // speed increase as time increases
                    y += speedVertical;
                }
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
        g.setColor(Color.black);
        g.drawLine(0, (int)GROUNDY, getWidth(), (int)GROUNDY);
        g.drawRect((int)x, (int)y, 100, 100);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        speedVertical -= 4;
        y += speedVertical;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KeyReleased");
    }
}
