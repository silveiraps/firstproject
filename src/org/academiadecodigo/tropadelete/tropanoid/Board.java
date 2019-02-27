package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Brick;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;

public class Board {

    public static final int PADDING = 10;
    public static final int GRID_HEIGHT = 640;
    public static final int GRID_WIDTH = 480;
    private Paddle paddle;
    private Ball ball;
    private Collision collision;

    private Brick[] bricks;
    private int numberOfBricks;


    public Board() {
        Rectangle grid = new Rectangle(PADDING, PADDING, GRID_WIDTH, GRID_HEIGHT);
        grid.draw();
        this.paddle = new Paddle();
        this.ball = new Ball();
        this.collision = new Collision(ball, paddle);

        int brickWidth = 40;
        int brickHeight = 20;
        numberOfBricks = 20;
        bricks = new Brick[numberOfBricks];

        for (int i = 0; i < GRID_WIDTH/brickWidth; i++) {
            for (int j = 0; j < 5; j++) {
                bricks[i] = new Brick(PADDING + i * brickWidth, PADDING + j * brickHeight);
            }

        }
    }
        public void start() {

            while (true) {
                try {
                    paddle.move();
                    ball.move();
                    collision.check();
                    //  System.out.println(ball.getPositionX()+" "+ball.getPositionY());
                } catch (InterruptedException e) {
                }
            }
        }

        public static int getPADDING () {
            return PADDING;
        }

        public static int getHEIGHT () {
            return GRID_HEIGHT;
        }

        public static int getWIDTH () {
            return GRID_WIDTH;
        }

        public Paddle getPaddle () {
            return paddle;
        }
    }
