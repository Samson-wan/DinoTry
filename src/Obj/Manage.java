package Obj;

import Interaction.GamePanel;
import UtilityAndResources.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Manage {
    private List<Obstacle> enemies;
    private BufferedImage image1;
    private BufferedImage image2;
    private Dinosaur dino;
    private GamePanel panel;

    public Manage(Dinosaur dino, GamePanel panel){
        this.panel = panel;
        this.dino = dino;
        enemies = new ArrayList<Obstacle>();
        Cactus cactus = new Cactus(dino);
        image1 = Resource.getImage("pictures/cactus1.png");
        image2 = Resource.getImage("pictures/cactus2.png");
        enemies.add(getRandom());
    }

    public void update(){
        for(Obstacle enemy : enemies){
            enemy.moveCactus();
            if(enemy.isGameOver() && !enemy.isScoreGot()){
                panel.plusGameScore(20);
                enemy.setScoreGot(true);
            }
            if(enemy.getRect().intersects(dino.getRect())){
                dino.setSurvive(false);
            }
        }
        Obstacle first = enemies.get(0);
        if(first.isOut()){
            enemies.remove(first);
            enemies.add(getRandom());
        }
    }

    public void drawEnemies(Graphics g){
        for(Obstacle enemy : enemies){
            enemy.drawCactus(g);
        }
    }

    public Cactus getRandom(){
        Cactus cactus = new Cactus(dino);
        cactus.setPositionHorizontal(600);
        int num = (int)(Math.random() * 2);
        if(num == 0){
            cactus.setCactusImage(image1);
        }
        else{
            cactus.setCactusImage(image2);
        }
        return cactus;
    }
}
