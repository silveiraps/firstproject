package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Brick;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;

public class Collision {

    private Ball ball;
    private Paddle paddle;
    private Brick brick;

    public Collision(Ball ball, Paddle paddle) {

        this.ball = ball;
        this.paddle = paddle;
        this.brick = brick;
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
        boolean checkY = ball.getPositionY() + ball.getRADIUS()-1 == paddle.getPositionY();
        boolean checkLeftSideUp = ball.getPositionX() == rightLimit && (ballLeftDownLimit>paddle.getPositionY()&&ballLeftCentreLimit<paddle.getPositionY());
        boolean checkLeftSideDown = ball.getPositionX() == rightLimit && (ballLeftUpLimit<paddle.getPositionY()&&ballLeftCentreLimit>=paddle.getPositionY());
        boolean checkRightSideUp = ball.getPositionX()+ball.getRADIUS() == leftLimit && (ballRightDownLimit>paddle.getPositionY()&&ballRightCentreLimit<paddle.getPositionY());
        boolean checkRightSideDown = ball.getPositionX()+ball.getRADIUS() == leftLimit && (ballRightUpLimit<paddle.getPositionY()&&ballRightCentreLimit>=paddle.getPositionY());


        System.out.println("x" + checkX);
        System.out.println("y" + checkY);
        if (checkY && checkX) {
            ball.invertSpeedY();
        }
        if(checkLeftSideUp){
            ball.invertSpeedY();
        }
        if(checkLeftSideDown){
            ball.invertSpeedY();
        }
        if(checkRightSideUp){
            ball.invertSpeedY();
        }
        if(checkRightSideDown){
            ball.invertSpeedY();
        }
    }

    public void checkBrickCollision(Brick brick) {

        int brickLeftLimit = brick.getPosX();
        int brickRightLimit = brick.getPosX() + Brick.getWIDTH();
        int brickUpLimit = brick.getPosY();
        int brickDownLimit = brick.getPosY() + Brick.getHEIGHT();

        boolean checkLeft = ball.getPositionX() + ball.getRADIUS() > brickLeftLimit && ball.getPositionX() + ball.getRADIUS() < brickRightLimit;
        boolean checkRight = ball.getPositionX() + ball.getRADIUS() < brickRightLimit && ball.getPositionX() + ball.getRADIUS() > brickLeftLimit;
        boolean checkUp = ball.getPositionY() + ball.getRADIUS() > brickUpLimit && ball.getPositionY() + ball.getRADIUS() < brickDownLimit;
        boolean checkDown = ball.getPositionY() + ball.getRADIUS() < brickDownLimit && ball.getPositionY() + ball.getRADIUS() > brickUpLimit;

        if (checkLeft && checkUp) {
            if (brick.isDestroyed()) {
                return;
            }
            brick.setDestroyed();
            brick.hideBrick();
        }

        if (checkRight) {
            if (brick.isDestroyed()) {
                return;
            }
            brick.setDestroyed();
            brick.hideBrick();
        }

        if (checkUp) {
            if (brick.isDestroyed()) {
                return;
            }
            brick.setDestroyed();
            brick.hideBrick();
        }

        if (checkDown) {
            if (brick.isDestroyed()) {
                return;
            }
            brick.setDestroyed();
            brick.hideBrick();
        }

    }

}
