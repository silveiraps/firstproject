package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;

public class Collision {

    private Ball ball;
    private Paddle paddle;
    //private Brick brick;

    public Collision(Ball ball, Paddle paddle) {

        this.ball = ball;
        this.paddle = paddle;
    }


    public void check() {

        int leftLimit = paddle.getPositionX();
        int rightLimit = (paddle.getPositionX() + paddle.getWIDTH());

        int ballX = ball.getPositionX() + ball.getRADIUS() / 2;

        boolean checkX = ballX > leftLimit && ballX < rightLimit;
        boolean checkY = ball.getPositionY() + ball.getRADIUS() == paddle.getPositionY();

        System.out.println("x" + checkX);
        System.out.println("y" + checkY);
        if (checkY && checkX) {
            ball.invertSpeedY();
        }
    }

}
