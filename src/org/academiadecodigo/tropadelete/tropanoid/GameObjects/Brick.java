package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Brick {

    private static final int WIDTH = 49;
    private static final int HEIGHT = 15;
    private Picture picture;
    private int posX;
    private int posY;
    private Color color;
    private boolean isDestroyed;

    public Brick(int posX, int posY) {

        this.posX = posX;
        this.posY = posY;
        picture = new Picture(posX, posY, randomBrick());
        //rectangle.setColor(color);
        this.color = color;
        this.isDestroyed = false;
        showBrick();

    }

    public void showBrick() {
        picture.draw();
    }

    public String randomBrick() {

        String brickOne = "brick.png";
        String brickTwo = "brick1.png";
        String brickThree = "brick2.png";

        int randomNumber = (int) (Math.random() * 10);

        if (randomNumber <= 3) {
            return brickOne;
        }

        if (randomNumber > 3 && randomNumber <= 6) {
            return brickTwo;
        }

        if (randomNumber > 6) {
            return brickThree;
        }
        return null;
    }

    public void hideBrick() {
        picture.delete();
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

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed() {
        isDestroyed = true;
    }

}