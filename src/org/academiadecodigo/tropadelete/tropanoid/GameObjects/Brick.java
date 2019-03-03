package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Brick {

    private static final int WIDTH = 47;
    private static final int HEIGHT = 15;
    private Rectangle rectangle;
    private int posX;
    private int posY;
    private Color color;
    private boolean isDestroyed;
    private int life;

    public Brick(int posX, int posY, Color color) {

        this.posX = posX;
        this.posY = posY;
        rectangle = new Rectangle(posX, posY, WIDTH, HEIGHT);
        rectangle.setColor(color);
        this.color = color;
        this.isDestroyed = false;
        this.life = (int) (Math.random() * 4);
        if (life == 0) {
            isDestroyed = true;
        } else {
            showBrick();
        }
    }

    public void showBrick() {
        rectangle.fill();
    }

    public void hideBrick() {
        rectangle.delete();
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed() {
        isDestroyed = true;
    }

    public void reduceLife() {
        this.life--;
    }

    public int getLife() {
        return life;
    }
}
