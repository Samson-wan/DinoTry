package Interaction;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame{ //Extends JFrame because when the placePicture Initialize, the Java itself has to draw Auto
    private GamePanel panel;

    public GameWindow(){
        super("Chrome Dino Run"); //Create new Frame
        setSize(600, 175);
        setLocation(500, 300); // set GameWindow location on the computer screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Make Frame become visible
        panel = new GamePanel();
        add(panel);
        addKeyListener(panel);
        addMouseListener(panel);
        setVisible(true);
    }

    public static void start(){
        GamePanel.activate();
    }

    public static void main(String[] args){
        GameWindow frame = new GameWindow(); //Create new GamePanel to call itself in the Main class
        frame.start();
    }
}
