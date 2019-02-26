package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.tropanoid.Board;
import org.academiadecodigo.tropadelete.tropanoid.Direction;

public class Paddle extends GameObjects {

    private int width;
    private int height;
    private Rectangle[] paddle;
    private Direction direction;

    public Paddle() {

        width = 15;
        height = 5;

        int centerZero = Board.getWIDTH() / 2 - (width / 2);
        int leftZero = centerZero - width;
        int rightZero = centerZero + width;

        Rectangle paddleCenter = new Rectangle(centerZero, Board.getHEIGHT(), width, height);
        Rectangle paddleLeft = new Rectangle(leftZero, Board.getHEIGHT(), width, height);
        Rectangle paddleRight = new Rectangle(rightZero, Board.getHEIGHT(), width, height);

        paddle = new Rectangle[3];
        paddle[0] = paddleLeft;
        paddle[1] = paddleCenter;
        paddle[2] = paddleRight;

        show();
    }

    public void show() {
        paddle[0].fill();
        paddle[1].fill();
        paddle[2].fill();
    }

    public void move() throws InterruptedException {
        if (direction == Direction.LEFT) {
            for (int i = 0; i < paddle.length; i++) {
                if (paddle[i].getX() <= Board.getPADDING()) {
                    return;
                }
            }

            paddle[0].translate(-10, 0);
            paddle[1].translate(-10, 0);
            paddle[2].translate(-10, 0);
            Thread.sleep(50);
        }
        if (direction == Direction.RIGHT) {
            for (int i = 0; i < paddle.length; i++) {
                if (paddle[i].getX() >= Board.getWIDTH() - Board.getPADDING()) {
                    return;
                }
            }
            paddle[0].translate(10, 0);
            paddle[1].translate(10, 0);
            paddle[2].translate(10, 0);
            Thread.sleep(50);
        }
        if (direction == null) {

            Thread.sleep(50);
        }
        show();
    }

    public void setDirection(Direction direction) {

        this.direction = direction;
    }

    public Direction getDirection() {

        return direction;
    }
}
