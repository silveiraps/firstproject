package org.academiadecodigo.tropadelete.tropanoid.Utils;

import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;

public class Collision {

    private Ball ball;
    private Paddle paddle;


    public Collision(Ball ball, Paddle paddle) {
        this.ball = ball;
        this.paddle = paddle;
    }

    public void checkBallPaddle(Ball ball, Paddle paddle) {
        double paddleUpperLimit = paddle.getY();
        double paddleLowerLimit = paddle.getY() + paddle.getImageHeight();

        double paddleLeftLimit = paddle.getX();
        double paddleRightLimit = paddle.getX() + paddle.getImageWidth();

        double ballCenterX = ball.getX() + ball.getRADIUS() / 2;
        double ballCenterY = ball.getY() + ball.getRADIUS() / 2;

        double ballUpperLimit = ball.getY();
        double ballLowerLimit = ball.getY() + ball.getRADIUS();

        double ballLeftLimit = ball.getX();
        double ballRightLimit = ball.getX() + ball.getRADIUS();

        boolean ballPaddleYCollision = ballLowerLimit >= paddleUpperLimit - 2 && ballLowerLimit <= paddleUpperLimit + 2;
        boolean ballPaddleXCollision = ballRightLimit >= paddleLeftLimit && ballLeftLimit <= paddleRightLimit;

        if (ballPaddleYCollision && ballPaddleXCollision) {
            if (ball.getDeltaY() < 0) {
                return;
            }
            double paddleBallDelta = ballRightLimit - paddleLeftLimit;

            if (paddleBallDelta >= 0 && paddleBallDelta <= (paddle.getImageWidth() + ball.getRADIUS()) * 3 / 7) {

                ball.setDirection(ball.getDirection().getNext(1));
            }

            if (paddleBallDelta >= (paddle.getImageWidth() + ball.getRADIUS()) * 4 / 7 &&
                    paddleBallDelta <= (paddle.getImageWidth() + ball.getRADIUS())) {

                ball.setDirection(ball.getDirection().getNext(-1));

            }

            ball.setDirection(ball.getDirection().getOppositeY());
            ball.updateDeltas();

        }
    }

}