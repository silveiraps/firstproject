package org.academiadecodigo.tropadelete.tropanoid.Utils;

import org.academiadecodigo.tropadelete.tropanoid.Board;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Brick;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;

public class Collision {

    public void checkBallBrick(Ball ball, Brick[] bricks) {

        double ballUpperLimit = ball.getY();
        double ballLeftLimit = ball.getX();
        double ballRightLimit = ball.getX() + ball.getDIAMETER();
        double ballLowerLimit = ball.getY() + ball.getDIAMETER();


        for (int i = 0; i < bricks.length; i++) {

            double brickUp = bricks[i].getPosY();
            double brickDown = bricks[i].getPosY() + Brick.getHEIGHT();
            double brickLeft = bricks[i].getPosX();
            double brickRight = bricks[i].getPosX() + Brick.getWIDTH();



            boolean upCheck = ballLowerLimit >= brickUp;
            boolean lefCheck = ballRightLimit >= brickLeft;
            boolean righCheck = ballLeftLimit <= brickRight;
            boolean downCheck = ballUpperLimit <= brickDown;


            boolean insideX = righCheck && lefCheck;
            boolean insideY = upCheck && downCheck;

            if (insideX && insideY) {

                if (!bricks[i].isDestroyed()) {

                    bricks[i].setDestroyed();

                    bricks[i].hideBrick();

                    ball.setDirection(ball.getDirection().getOppositeY());
                    ball.updateDeltas();
                }
            }
        }
    }

    public void checkBallPaddle(Ball ball, Paddle paddle) {
        double paddleUpperLimit = paddle.getY();
        double paddleLowerLimit = paddle.getY() + paddle.getImageHeight();

        double paddleLeftLimit = paddle.getX();
        double paddleRightLimit = paddle.getX() + paddle.getImageWidth();

        double ballCenterX = ball.getX() + ball.getDIAMETER() / 2;
        double ballCenterY = ball.getY() + ball.getDIAMETER() / 2;

        double ballUpperLimit = ball.getY();
        double ballLowerLimit = ball.getY() + ball.getDIAMETER();

        double ballLeftLimit = ball.getX();
        double ballRightLimit = ball.getX() + ball.getDIAMETER();


        boolean upSide = ballLowerLimit >= paddleUpperLimit;
        boolean leftSide = ballRightLimit >= paddleLeftLimit;
        boolean rightSide = ballLeftLimit <= paddleRightLimit;
        boolean downSide = ballUpperLimit <= paddleLowerLimit;



        if ((upSide && downSide && leftSide && rightSide)) {


            if (ball.getDeltaY() < 0) {
                return;
            }
            double paddleBallDelta = ballRightLimit - paddleLeftLimit;

            if (paddleBallDelta >= 0 && paddleBallDelta <= (paddle.getImageWidth() + ball.getDIAMETER()) * 0.5) {

                ball.setDirection(ball.getDirection().getNext(1));
            }

            if (paddleBallDelta >= (paddle.getImageWidth() + ball.getDIAMETER()) * 0.5 &&
                    paddleBallDelta <= (paddle.getImageWidth() + ball.getDIAMETER())) {

                ball.setDirection(ball.getDirection().getNext(-1));

            }

            ball.setDirection(ball.getDirection().getOppositeY());
            ball.updateDeltas();

        }

    }
}