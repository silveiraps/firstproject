package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Brick {

    private static final int WIDTH = 49;
    private static final int HEIGHT = 15;
    private Rectangle rectangle;
    private int posX;
    private int posY;
    private Color color;
    private boolean isDestroyed;

    public Brick(int posX, int posY, Color color) {

        rectangle = new Rectangle(posX,posY, WIDTH, HEIGHT);
        this.posX = posX;
        this.posY = posY;
<<<<<<< HEAD
        rectangle = new Rectangle(posX,posY, WIDTH, HEIGHT);
        rectangle.setColor(color);
=======
        this.color = color;
        this.isDestroyed = false;
>>>>>>> c1dcd67df4c8eacad9f9e81d61e7224fec8f8141
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

<<<<<<< HEAD
    public void setColor(Color color) {
        this.color = color;
    }
=======
    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed() {
        isDestroyed = true;
    }

>>>>>>> c1dcd67df4c8eacad9f9e81d61e7224fec8f8141
}
