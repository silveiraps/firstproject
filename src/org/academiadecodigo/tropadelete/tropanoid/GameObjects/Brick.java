package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Brick extends GameObjects {

    private int height;
    private int width;
    private int positionX;
    private int positionY;
    private Rectangle brick;
    private boolean alive;

    public Brick(int positionX, int positionY) {
        width = 40;
        height = 20;
        this.positionX = positionX;
        this.positionY = positionY;
        alive = true;

        brick = new Rectangle(positionX, positionY, width, height);
        Color color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        brick.setColor(color);
        brick.fill();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
