package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;
import org.academiadecodigo.tropadelete.tropanoid.Utils.Collision;

public class Board {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 640;
    public static final int PADDING = 10;
    public static final int PADDLE_Y = HEIGHT - 30;

    private Paddle paddle;
    private Ball ball;
    private Collision collision;

    public Board() {

        Rectangle grid = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        grid.draw();
        this.paddle = new Paddle();
        this.ball = new Ball(paddle);
        this.collision = new Collision(ball,paddle);
    }

    public void start() {

        while (true) {
            try {
                paddle.move();
                ball.move(collision);

                Thread.sleep(5);
                //  System.out.println(ball.getPositionX()+" "+ball.getPositionY());
            } catch (InterruptedException e) {

            }
        }
    }

    public Paddle getPaddle() {
        return paddle;
    }
}