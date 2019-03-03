package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.tropadelete.tropanoid.Utils.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.tropanoid.Board;
import org.academiadecodigo.tropadelete.tropanoid.Utils.PaddleDirection;

public class Paddle extends GameObject {

    private PaddleDirection direction;
    private int deltaX;
    private Picture paddle;
    private int speed;
    private Sound paddleHit;

    public Paddle() {
        imageWidth = 80;
        imageHeight = 10;
        deltaX = 1;
        speed=3;

        x = (Board.WIDTH +Board.PADDING)/ 2 - imageWidth / 2;
        y = Board.PADDLE_Y;

        paddleHit = new Sound("/paddlehit.wav");

        paddle = new Picture(x, y, "tropanoid_graphics_paddle.png");
        show();

    }

    public void move() {

        if (direction == PaddleDirection.LEFT) {

            paddle.translate(-deltaX*speed,0);

            if (paddle.getX() < Board.PADDING) {

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
        paddle.draw();
    }

    public void setDirection(PaddleDirection direction) {

        this.direction = direction;
    }
    public void reset() {
        paddle.translate((Board.WIDTH +Board.PADDING)/ 2 - imageWidth / 2-x,0);
        x = paddle.getX();
    }

    public Sound getPaddleHit() {
        return paddleHit;
    }
}
