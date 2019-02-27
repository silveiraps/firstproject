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
        int ballLeftUpLimit = ball.getPositionY();
        int ballLeftCentreLimit = ballLeftUpLimit+ball.getRADIUS()/2;
        int ballLeftDownLimit = ballLeftUpLimit+ball.getRADIUS();
        int ballRightUpLimit = ballLeftUpLimit + ball.getRADIUS();
        int ballRightCentreLimit = ballLeftCentreLimit + ball.getRADIUS();
        int ballRightDownLimit = ballLeftDownLimit + ball.getRADIUS();

        int ballX = ball.getPositionX() + ball.getRADIUS() / 2;

        boolean checkX = ballX >= leftLimit && ballX <= rightLimit;
        boolean checkY = ball.getPositionY() + ball.getRADIUS() == paddle.getPositionY();
        boolean checkLeftSideUp = ball.getPositionX() == rightLimit && (ballLeftDownLimit>paddle.getPositionY()&&ballLeftCentreLimit<paddle.getPositionY());
        boolean checkLeftSideDown = ball.getPositionX() == rightLimit && (ballLeftUpLimit<paddle.getPositionY()&&ballLeftCentreLimit>=paddle.getPositionY());
        boolean checkRightSideUp = ball.getPositionX()+ball.getRADIUS() == leftLimit && (ballRightDownLimit>paddle.getPositionY()&&ballRightCentreLimit<paddle.getPositionY());
        boolean checkRightSideDown = ball.getPositionX()+ball.getRADIUS() == leftLimit && (ballRightUpLimit<paddle.getPositionY()&&ballRightCentreLimit>=paddle.getPositionY());
        boolean checkLose = ball.getPositionY()+ball.getRADIUS() >= Board.getHEIGHT();


        System.out.println("x" + checkX);
        System.out.println("y" + checkY);
        if(checkLose){
            ball.reset();
        }

        if (checkY && checkX) {
            ball.invertSpeedY();
        }
        if(checkLeftSideDown){
            ball.invertSpeedY();
        }
        if(checkRightSideDown){
            ball.invertSpeedY();
        }
    }

}
