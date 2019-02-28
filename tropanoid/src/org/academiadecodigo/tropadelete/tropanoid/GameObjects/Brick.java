package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Brick extends GameObject {

    private boolean destroyed;
    private static final int BRICK_WIDTH = 40;
    private static final int BRICK_HEIGHT = 20;
    private Rectangle brick;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;

        destroyed = false;
        brick = new Rectangle(x,y,BRICK_WIDTH, BRICK_HEIGHT);
        brick.fill();
    }

}
