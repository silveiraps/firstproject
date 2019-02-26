package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;

public class Board {

    public static final int PADDING = 10;
    public static final int HEIGHT = 640;
    public static final int WIDTH = 480;
    private Paddle paddle;
    private Ball ball;


    public Board() {
        Rectangle grid = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        grid.draw();
        this.paddle = new Paddle();
        this.ball = new Ball();


    }

    public void start() {

        while (true) {
            try {
                paddle.move();
               // ball.move();
                System.out.println(ball.getPositionX()+" "+ball.getPositionY());
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
