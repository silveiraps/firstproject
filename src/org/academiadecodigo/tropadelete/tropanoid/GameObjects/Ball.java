package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.tropadelete.tropanoid.Board;
import org.academiadecodigo.tropadelete.tropanoid.Utils.BallDirection;
import org.academiadecodigo.tropadelete.tropanoid.Utils.Collision;

public class Ball extends GameObject {

    private final double DIAMETER = 10;

    private double deltaX;
    private double deltaY;
    private double speed;

    private BallDirection direction;
    private Ellipse ball;
    private Paddle paddle;

    public Ball(Paddle paddle) {

        this.paddle = paddle;
        x = (Board.WIDTH - DIAMETER) / 2;
        y = Board.PADDLE_Y - DIAMETER;
        speed = 1;

        direction = BallDirection.pick();
        updateDeltas();

        ball = new Ellipse(x, y, DIAMETER, DIAMETER);
        show();
    }

    public void move(Collision collision) {

        double prevX = ball.getX();
        double prevY = ball.getY();

        if (ball.getX() < Board.PADDING || ball.getX() + DIAMETER > Board.WIDTH + Board.PADDING - 1) {


            this.direction = direction.getOppositeX();
            updateDeltas();

        }
        if (ball.getY() <= Board.PADDING || ball.getY() >= Board.HEIGHT) {

            this.direction = direction.getOppositeY();
            updateDeltas();
        }

        x += deltaX * speed;
        y += deltaY * speed;

        ball.translate(x - prevX, y - prevY);
        collision.checkBallPaddle(this, paddle);
        show();

    }

    public void show() {
        ball.draw();
    }

    public void updateDeltas() {
        deltaX = direction.getDeltaX();
        deltaY = direction.getDeltaY();
    }

    public void reset() {
        ball.translate(Board.WIDTH / 2 - x, (Board.PADDLE_Y - DIAMETER) - y);
        x = ball.getX();
        y = ball.getY();
    }

    public void setDirection(BallDirection direction) {
        this.direction = direction;
    }

    public double getDIAMETER() {
        return DIAMETER;
    }

    public BallDirection getDirection() {
        return direction;
    }

    public double getDeltaY() {
        return deltaY;
    }
}
