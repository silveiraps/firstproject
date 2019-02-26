package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;

import java.awt.*;

public class Collision {

    private Ball ball;
    private Rectangle[] paddle;
    //private Brick brick;

    public Collision(Ball ball, Rectangle[] paddle) {

        this.ball = ball;
        this.paddle = paddle;
    }


    public void check() {

        boolean checkY = ball.getPositionY() + ball.getRADIUS() == paddle[0].getY();

        int leftLimit = (int) paddle[0].getX();
        int rightLimit = (int) (paddle[2].getX()+paddle[2].getWidth());
        int ballX = ball.getPositionX() + ball.getRADIUS()/2;

        boolean checkX = ballX > leftLimit && ballX < rightLimit;

        if (checkY && checkX) {
            ball.invertSpeedY();
        }
    }

}
