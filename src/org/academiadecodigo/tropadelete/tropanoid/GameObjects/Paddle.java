package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.tropanoid.Board;
import org.academiadecodigo.tropadelete.tropanoid.Utils.PaddleDirection;

public class Paddle extends GameObject {

    private PaddleDirection direction;
    private int deltaX;
    private Rectangle paddle;
    private int speed;

    public Paddle() {
        imageWidth = 80;
        imageHeight = 10;
        deltaX = 1;
        speed=3;

        x = Board.WIDTH / 2 - imageWidth / 2;
        y = Board.PADDLE_Y;

        paddle = new Rectangle(x, y, imageWidth, imageHeight);
        show();
    }

    public void move() {

        if (direction == PaddleDirection.LEFT) {

            paddle.translate(-deltaX*speed,0);

            if (paddle.getX() <= Board.PADDING+1) {

                paddle.translate(deltaX*speed,0);
            }
            x = paddle.getX();
        }

        if (direction == PaddleDirection.RIGHT) {

             paddle.translate(deltaX*2,0);

            if (paddle.getX() + imageWidth >= Board.WIDTH + Board.PADDING) {

                paddle.translate(-deltaX*2,0);
            }
            x = paddle.getX();
        }
        show();
    }

    public void show() {
        paddle.fill();
    }

    public void setDirection(PaddleDirection direction) {

        this.direction = direction;
    }
}
