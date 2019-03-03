package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Brick;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;
import org.academiadecodigo.tropadelete.tropanoid.Utils.BrickFactory;
import org.academiadecodigo.tropadelete.tropanoid.Utils.Collision;

public class Board {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 640;
    public static final int PADDING = 10;
    public static final int PADDLE_Y = HEIGHT - 30;

    private Paddle paddle;
    private Ball ball;
    private Collision collision;
    private Brick[] bricks;
    private Picture board;
    private int lives;
    private boolean moveBall;
    private GameStartFX startFx;

    public Board() {

        this.board = new Picture(PADDING, PADDING, "tropanoid_graphics_board.png");
        board.draw();

        this.paddle = new Paddle();
        this.ball = new Ball(paddle);
        this.collision = new Collision();
        this.bricks = BrickFactory.CreateBricks(200);
        this.moveBall = false;
        this.lives = 4;
        startFx = new GameStartFX();
    }

    public void start() {
startFx.readyGoText();
        while (lives > 0 || checkBricksAlive(bricks)) {
            System.out.println("");
            if (!moveBall) {
                continue;
            }
            try {
                if (ball.getY() + ball.getDIAMETER() >= Board.HEIGHT) {
                    lives--;

                    if (lives == 0) {
                        Picture gameOver = new Picture(PADDING, PADDING * 20, "tropanoid_graphics_gameover.png");
                        gameOver.draw();
                        return;
                    }

                    ball.reset();
                    paddle.reset();
                    Thread.sleep(1000);
                    continue;
                }
                paddle.move();
                ball.move(collision);
                collision.checkBallBrick(ball, bricks);

                Thread.sleep(5);

            } catch (InterruptedException e) {
            }
        }
    }


    public Paddle getPaddle() {
        return paddle;
    }

    public void setMoveBall() {

        if (!moveBall) {
            this.moveBall = true;
        } else {
            this.moveBall = false;
        }
    }

    public boolean checkBricksAlive(Brick[] bricks) {

        for (int i = 0; i < bricks.length; i++) {
            if (bricks[i].getLife() > 0) {
                return true;
            }
        }
        return false;
    }
}
