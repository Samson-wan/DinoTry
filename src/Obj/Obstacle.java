package Obj;

import java.awt.*;

public abstract class Obstacle {
    public abstract Rectangle getRect();
    public abstract void drawCactus(Graphics g);
    public abstract void moveCactus();
    public abstract boolean isOut();
    public abstract boolean isGameOver();
    public abstract boolean isScoreGot();
    public abstract void setScoreGot(boolean score);
}
