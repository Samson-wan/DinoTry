package Interaction;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame{ //Extends JFrame because when the placePicture Initialize, the Java itself has to draw Auto
    private GamePanel panel;

    public GameWindow(){
        super("Chrome Dino Run"); //Create new Frame
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Make Frame become visible
        setVisible(true);
        panel = new GamePanel();
        add(panel);
        addKeyListener(panel);
    }

    public static void start(){
        GamePanel.activate();
    }

    public static void main(String[] args){
        GameWindow frame = new GameWindow(); //Create new GamePanel to call itself in the Main class
        frame.start();
    }



//    public void paint(Graphics g){  //Draw elements on the GamePanel with paint class
//        super.paint(g);
//        BufferedImage cactus1 = null; //set it to default
//        try{
//            cactus1 = ImageIO.read(new File("pictures/cactus1.png"));//Grab the image in the pictures folder of my project
//            g.drawImage(cactus1, 100, 100, null); //draw Cactus1 with drawImage method
//        }
//        catch(IOException e){
//            e.printStackTrace(); //catch exception
//        }
//    }
}
