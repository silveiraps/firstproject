package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.tropanoid.Board;
import org.academiadecodigo.tropadelete.tropanoid.Direction;

public class Paddle extends GameObjects {

    private static final int WIDTH = 50;
    private static final int HEIGHT = 5;
    private Rectangle paddle;
    private Direction direction;
    private int positionX;
    private int positionY;

    public Paddle() {

        positionX = Board.getWIDTH() / 2 - WIDTH / 2;
        positionY = Board.getHEIGHT();

        this.paddle = new Rectangle(positionX, positionY, WIDTH, HEIGHT);

        show();
    }

    public void show() {
        paddle.fill();
    }

    public void move() throws InterruptedException {



        if (direction == Direction.LEFT) {
            paddle.translate(-10, 0);

            if (paddle.getX() <= Board.PADDING) {
                paddle.translate(10, 0);
            }
            this.positionX=paddle.getX();
        }
        if (direction == Direction.RIGHT) {
            paddle.translate(10, 0);
            if (paddle.getX()+ WIDTH >= Board.getWIDTH()) {
                paddle.translate(-10,0);
            }
            this.positionX=paddle.getX();
        }

        /*if (direction == Direction.LEFT && paddle.getX() > Board.PADDING) {
            paddle.translate(-10, 0);

            Thread.sleep(1);
        }
        if (direction == Direction.RIGHT && paddle.getX() + WIDTH < Board.getWIDTH()) {
            paddle.translate(10, 0);

            Thread.sleep(1);
        }
        if (direction == null) {

        }*/
       /* if (direction == Direction.LEFT) {

            if (paddle.getX() <= Board.PADDING) {
                return;
            }

            paddle.translate(-10, 0);

        }
        if (direction == Direction.RIGHT) {

            if (paddle.getX()+ WIDTH >= Board.getWIDTH()) {
                return;
            }

            paddle.translate(10, 0);
        }
        if (direction == null) {

        }*/
        Thread.sleep(1);
        show();
    }

    public void setDirection(Direction direction) {

        this.direction = direction;
    }

    public Direction getDirection() {

        return direction;
    }

    public Rectangle getPaddle() {
        return paddle;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getWIDTH() {
        return WIDTH;
    }
}