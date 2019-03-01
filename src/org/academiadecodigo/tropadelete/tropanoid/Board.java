package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Brick;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.BrickFactory;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;

public class Board {

    public static final int PADDING = 10;
    public static final int HEIGHT = 640;
    public static final int WIDTH = 480;
    private Paddle paddle;
    private Ball ball;
    private Brick[] bricks;
    private Collision collision;


    public Board() {
        Rectangle grid = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        grid.draw();
        this.paddle = new Paddle();
        this.ball = new Ball();
        this.collision = new Collision(ball,paddle);
        this.bricks = BrickFactory.CreateBricks(50);
    }

    public void start() {

        while (true) {
            try {
                paddle.move();
                ball.move();
                collision.check();

                for (int i = 0; i < bricks.length; i++) {
                    collision.checkBrickCollision(bricks[i]);
                }

                //  System.out.println(ball.getPositionX()+" "+ball.getPositionY());
            } catch (InterruptedException e) {
            }
        }
    }

    public static int getPADDING() {
        return PADDING;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public Paddle getPaddle() {
        return paddle;
    }
}
