package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Brick {

    private static final int WIDTH = 49;
    private static final int HEIGHT = 15;
    private int posX;
    private int posY;
    private Rectangle rectangle;
    private Color color;

    public Brick(int posX, int posY, Color color) {

        this.posX = posX;
        this.posY = posY;
        rectangle = new Rectangle(posX,posY, WIDTH, HEIGHT);
        rectangle.setColor(color);
        showBrick();

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

    public void setColor(Color color) {
        this.color = color;
    }
}
