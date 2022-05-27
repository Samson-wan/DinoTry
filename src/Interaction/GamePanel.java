package Interaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Obj.*;
import UtilityAndResources.Resource;

public class GamePanel extends JPanel implements Runnable, KeyListener { //https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html
    private static Thread thread;
    public static final int GAME_FIRST = 0;
    public static final int GAME_PLAY = 1;
    public static final int GAME_OVER = 2;
    public static final float GRAVITY = 0.1f; //add suffix f to make it identify as a float
    public static final float GROUNDY = 110;
    private Dinosaur dino;
    private Ground ground;
    private Cloud cloud;
    private Manage manage;
    private int gameStatus;
    private BufferedImage iamgeGameOver;
    private int gameScore;
    private int highestScore;

    public GamePanel(){
        thread = new Thread(this);
        dino = new Dinosaur();
        dino.setX(50); //Initial x position;
        dino.setY(60); //Initial y position;
        ground = new Ground(this);
        cloud = new Cloud();
        manage = new Manage(dino, this);
        iamgeGameOver = Resource.getImage("pictures/gameover_text.png");
    }

    public static void activate(){
        thread.start();
    }
    @Override
    public void run() {
        while(true){
            try{
                change();
                repaint(); //call the paint method again after the x and y coordinate has been changed
                Thread.sleep(20);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void change(){
        switch (gameStatus){
            case GAME_PLAY:
                dino.changePosition();
                ground.landMoving();
                cloud.cloudMoving();
                manage.update();
                if(!dino.survive()){
                    gameStatus = 2;
                }
                break;
        }
    }

    public void plusGameScore(int gameScore) {
        this.gameScore += gameScore;
    }

    public void clearGameScore(){
        gameScore = 0;
    }

    public void paint(Graphics g){ //https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0, 0, getWidth(), getHeight());
//        g.setColor(Color.red);
//        g.drawLine(0, (int)GROUNDY, getWidth(), (int)GROUNDY);

        switch (gameStatus){
            case GAME_FIRST:
                dino.drawObj(g);
                break;
            case GAME_PLAY:
                ground.drawGround(g); //draw ground
                cloud.drawCloud(g); //draw cloud
                manage.drawEnemies(g);
                dino.drawObj(g); //draw dino
                g.drawString("Game Score: " + String.valueOf(gameScore), 300, 20);
                g.drawString("High Score: " + String.valueOf(gameScore), 500, 20);
                break;
            case GAME_OVER:
                ground.drawGround(g); //draw ground
                cloud.drawCloud(g); //draw cloud
                manage.drawEnemies(g);
                dino.drawObj(g); //draw dino
                g.drawImage(iamgeGameOver, 100, 50, null);
                break;
        }
//        ground.drawGround(g); //draw ground
//        cloud.drawCloud(g); //draw cloud
//        manage.drawEnemies(g);
//        dino.drawObj(g); //draw dino
    }

    public void resetGame(){
        dino.setSurvive(true);
        dino.setX(50);
        dino.setY(60);
        manage.reset();
        clearGameScore();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(gameStatus == 0){
                gameStatus = 1;
            }
            else if(gameStatus == 1){
                dino.dinoJump();
            }
            else if(gameStatus == 2){
                gameStatus = 1;
                resetGame();
            }
        }
    }
}
