package Obj;

import java.awt.*;

public abstract class Obstacle {
    public abstract Rectangle getRect();
    public abstract void drawCactus(Graphics g);
    public abstract void moveCactus(int changeSpeed);
    public abstract boolean isOut(int index);
    public abstract boolean isOutScreen();
    public abstract boolean isGameOver();
    public abstract boolean isScoreGot();
    public abstract void setScoreGot(boolean b);
}
