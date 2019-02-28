package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.tropadelete.tropanoid.Board;
import org.academiadecodigo.tropadelete.tropanoid.Utils.BallDirection;

public class Ball extends GameObject {

    private static final int RADIUS = 10;

    private double deltaX;
    private double deltaY;
    private int speed;

    private BallDirection direction;
    private Ellipse ball;
    private Paddle paddle;

    public Ball(Paddle paddle) {

        this.paddle = paddle;
        x = (Board.WIDTH - RADIUS) / 2;
        y = Board.PADDLE_Y - RADIUS;
        speed = 2;

        direction = BallDirection.pick();
        updateDeltas();

        ball = new Ellipse(x, y, RADIUS, RADIUS);
        show();
    }

    public void move() {

        double prevX = x;
        double prevY = y;

        if (x < Board.PADDING || x + RADIUS  > Board.WIDTH+Board.PADDING-1) {


            this.direction = direction.getOppositeX();
            updateDeltas();

        }
        if (y <= Board.PADDING || y >= Board.HEIGHT) {

            this.direction = direction.getOppositeY();
            updateDeltas();
        }

        x += deltaX * speed;
        y += deltaY * speed;

        ball.translate(x - prevX, y - prevY);
        checkCollision(paddle);
        show();
    }

    public void checkCollision(Paddle paddle) {

        double leftLimit = paddle.x;
        double rightLimit = paddle.x + paddle.imageWidth;
        double ballRightLimit = x + RADIUS;

        boolean checkX = ballRightLimit >= leftLimit && ballRightLimit <= rightLimit;
        boolean checkY = y + RADIUS == paddle.y;

        if (checkX && checkY) {
            double paddleBallDelta = (x + RADIUS) - paddle.x;


            System.out.println(direction);

            if (paddleBallDelta >= 0 && paddleBallDelta <= paddle.imageWidth / 4) {

                setDirection(direction.getNext(1));
                setDirection(direction.getOppositeY());
            }
            if (paddleBallDelta > paddle.imageWidth / 4 && paddleBallDelta < paddle.imageWidth* 3/ 4) {

                setDirection(direction.getOppositeY());
            }

            if (paddleBallDelta >= paddle.imageWidth * 3 / 4 && paddleBallDelta <= paddle.imageWidth) {

                setDirection(direction.getNext(-1));
                setDirection(direction.getOppositeY());
            }
            System.out.println(direction);
            updateDeltas();
            show();
        }
    }

    public void show() {
        ball.draw();
    }

    public void updateDeltas() {
        deltaX = direction.getDeltaX();
        deltaY = direction.getDeltaY();
    }

    public void setDirection(BallDirection direction) {
        this.direction = direction;
    }
}
