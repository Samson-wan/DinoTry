package Interaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Obj.*;
import UtilityAndResources.Resource;

public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener { //https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html
    private static Thread thread;
    public static final int GAME_FIRST = 0;
    public static final int GAME_PLAY = 1;
    public static final int GAME_OVER = 2;
    public static final float GRAVITY = 2f; //add suffix f to make it identify as a float
    public static final float GROUNDY = 110;
    private Dinosaur dino;
    private Ground ground;
    private Cloud cloud;
    private Manage manage;
    private int gameStatus;
    private BufferedImage imageGameOver;
    private BufferedImage refreshedButton;
    private int gameScore;
    private int highestScore;
    private BufferedImage dinoDied;
//    private Rectangle rect;

    public GamePanel(){
        thread = new Thread(this);
        dino = new Dinosaur();
        dino.setX(50); //Initial x position;
        dino.setY(60); //Initial y position;
        ground = new Ground(this);
        cloud = new Cloud();
        manage = new Manage(dino, this);
        imageGameOver = Resource.getImage("pictures/gameover_text.png");
        refreshedButton = Resource.getImage("pictures/replay_button.png");
        dinoDied = Resource.getImage("pictures/main-character4.png");
//        rect = new Rectangle();
//        rect.x = 280;
//        rect.y = 70;
//        rect.width = refreshedButton.getWidth();
//        rect.height = refreshedButton.getWidth();
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
                cloud.drawCloud(g); //draw cloud
                ground.drawGround(g); //draw ground
                manage.drawEnemies(g);
                dino.drawObj(g); //draw dino
                g.drawString("Game Score: " + String.valueOf(gameScore), 300, 20);
                g.drawString("High Score: " + String.valueOf(highestScore), 450, 20);
                break;
            case GAME_OVER:
                cloud.drawCloud(g); //draw cloud
                ground.drawGround(g); //draw ground
                manage.drawEnemies(g);
                g.drawImage(dinoDied, (int)dino.getX(), (int)dino.getY(), null); //draw dino
                g.drawImage(imageGameOver, 200, 30, null);
                g.drawImage(refreshedButton, 280, 70, null);
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
        highestScore = gameScore;
        clearGameScore();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
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


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.MOUSE_CLICKED == MouseEvent.BUTTON1){
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

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
