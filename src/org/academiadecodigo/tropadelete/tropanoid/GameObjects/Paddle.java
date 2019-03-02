package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.tropanoid.Board;
import org.academiadecodigo.tropadelete.tropanoid.Direction;

public class Paddle extends GameObjects {

    private static final int WIDTH = 80;
    private static final int HEIGHT = 5;
    private Picture paddle;
    private Direction direction;
    private int positionX;
    private int positionY;

    public Paddle() {

        positionX = Board.getWIDTH() / 2 - WIDTH / 2;
        positionY = Board.getHEIGHT();

        this.paddle = new Picture(positionX, positionY, "tropanoid_graphics_paddle.png");

        show();
    }

    public void show() {
        paddle.draw();
    }

    public void move() throws InterruptedException {



        if (direction == Direction.LEFT) {
            this.positionX=paddle.getX();

            if (paddle.getX() <= Board.PADDING) {
                return;
            }
            paddle.translate(-5, 0);
        }
        if (direction == Direction.RIGHT) {
            this.positionX=paddle.getX();

            if (paddle.getX()+ WIDTH >= Board.getWIDTH()+Board.PADDING) {
                return;
            }
            paddle.translate(5, 0);
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
        //Thread.sleep();
        show();
    }

    public void setDirection(Direction direction) {

        this.direction = direction;
    }

    public Direction getDirection() {

        return direction;
    }

    public Picture getPaddle() {
        return paddle;
    }

    public int getPositionY() {
        return paddle.getY();
    }

    public int getPositionX() {
        return paddle.getX();
    }

    public int getWIDTH() {
        return WIDTH;
    }
}