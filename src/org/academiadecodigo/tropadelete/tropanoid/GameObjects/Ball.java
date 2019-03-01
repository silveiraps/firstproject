package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.tropadelete.tropanoid.Board;
import org.academiadecodigo.tropadelete.tropanoid.Utils.BallDirection;
import org.academiadecodigo.tropadelete.tropanoid.Utils.Collision;

public class Ball extends GameObject {

    private final double  RADIUS = 10;

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

    public void move(Collision collision) {

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
        collision.checkBallPaddle(this,paddle);
        show();

    }

    @Override
    public double getX() {
        return ball.getX();
    }

    @Override
    public double getY() {
        return ball.getY();
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

    public double getRADIUS() {
        return RADIUS;
    }

    public BallDirection getDirection() {
        return direction;
    }

    public double getDeltaY() {
        return deltaY;
    }
}
