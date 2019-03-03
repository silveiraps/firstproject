package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Brick {

    private static final int WIDTH = 48;
    private static final int HEIGHT = 15;
    private Picture brick;
    private int posX;
    private int posY;
    private boolean isDestroyed;
    private double changeBallSpeed;
    private int life;

    public Brick(int posX, int posY, Color color) {

        this.posX = posX;
        this.posY = posY;
        brick = new Picture(posX,posY, randomBrick());
        this.isDestroyed = false;
        this.life = (int) (Math.random() * 4);
        if (life == 0) {
            isDestroyed = true;
        } else {
            showBrick();
        }

    }

    public void showBrick() {
        brick.draw();
    }

    public void hideBrick() {
        brick.delete();
    }

    public String randomBrick() {

        String brickOne = "tropanoid_graphics_brick1.png";
        String brickTwo = "tropanoid_graphics_brick2.png";
        String brickThree = "tropanoid_graphics_brick3.png";

        int randomNumber = (int) (Math.random() * 3);

        if (randomNumber == 0) {
            this.changeBallSpeed = 1;
            return brickOne;
        }

        if (randomNumber == 1) {
            this.changeBallSpeed = 1.5;
            return brickTwo;
        }

        this.changeBallSpeed = 2;
        return brickThree;

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

    public double getChangeBallSpeed() {
        return changeBallSpeed;
    }
}
