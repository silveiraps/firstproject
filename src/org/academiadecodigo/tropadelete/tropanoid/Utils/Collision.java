package org.academiadecodigo.tropadelete.tropanoid.Utils;

import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Brick;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;

public class Collision {



    public void checkBallBrick(Ball ball, Brick[] bricks) {

        double ballUp = ball.getY();
        double ballLeft = ball.getX();
        double ballRight = ball.getX() + ball.getDIAMETER();
        double ballDown = ball.getY() + ball.getDIAMETER();
        double ballCenterX = ball.getX() + ball.getDIAMETER() / 2;
        double ballCenterY = ball.getY() + ball.getDIAMETER() / 2;

        for (int i = 0; i < bricks.length; i++) {

            double brickUp = bricks[i].getPosY();
            double brickDown = bricks[i].getPosY() + Brick.getHEIGHT();
            double brickLeft = bricks[i].getPosX();
            double brickRight = bricks[i].getPosX() + Brick.getWIDTH();


            boolean upCheck = ballDown >= brickUp;
            boolean lefCheck = ballRight >= brickLeft;
            boolean righCheck = ballLeft <= brickRight;
            boolean downCheck = ballUp <= brickDown;

            boolean ballBelow = ballCenterY > brickDown;
            boolean ballAbove = ballCenterY < brickUp;
            boolean ballAtLeft = ballCenterX < ballRight;
            boolean ballAtRight = ballCenterX > brickLeft;


            boolean insideX = righCheck && lefCheck;
            boolean insideY = upCheck && downCheck;

            if (!bricks[i].isDestroyed()) {

                if (insideX && insideY) {

                    bricks[i].getBrickHit().play(true);

                    if(ballAbove || ballBelow) {
                        ball.setDirection(ball.getDirection().getOppositeY());

                        changeBrickLife(ball,bricks,i);
                        break;
                    }
                    if (ballAtLeft || ballAtRight) {
                        ball.setDirection(ball.getDirection().getOppositeX());

                        changeBrickLife(ball,bricks,i);
                        break;
                    }
                }
            }
        }
    }
    public void changeBrickLife(Ball ball,Brick[] bricks, int i) {
        ball.updateDeltas();
        ball.setSpeed(bricks[i].getChangeBallSpeed());
        bricks[i].reduceLife();

        if(bricks[i].getLife()==0) {
            bricks[i].setDestroyed();
            bricks[i].hideBrick();
            bricks[i].getDestroyBrick().play(true);
            return;
        }
        bricks[i].getBrickHit().play(true);

    }

    public void checkBallPaddle(Ball ball, Paddle paddle) {
        double paddleUpperLimit = paddle.getY();
        double paddleLowerLimit = paddle.getY() + paddle.getImageHeight();

        double paddleLeftLimit = paddle.getX();
        double paddleRightLimit = paddle.getX() + paddle.getImageWidth();

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
            paddle.getPaddleHit().play(true);
        }

    }
}