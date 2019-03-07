package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Brick;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;
import org.academiadecodigo.tropadelete.tropanoid.Utils.BrickFactory;
import org.academiadecodigo.tropadelete.tropanoid.Utils.Collision;
import org.academiadecodigo.tropadelete.tropanoid.Utils.Sound;

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
    private Picture menu;
    private Picture gameOver;
    private Sound lose1;
    private Sound lose2;
    private Sound lastLife;
    private Picture livesPic;


    public Board() {
        this.lives = 4;
        this.menu = new Picture(PADDING,PADDING,"tropanoid_graphics_menu.png");
        this.board = new Picture(PADDING, PADDING, "tropanoid_graphics_board.png");
        this.livesPic = new Picture(PADDING,PADDING, "/4lifes.png");
        this.paddle = new Paddle();
        this.ball = new Ball(paddle);
        this.collision = new Collision();
        this.bricks = BrickFactory.CreateBricks(200);
        this.moveBall = false;

        startFx = new GameStartFX();

        lose1= new Sound("/1no.wav");
        lose2= new Sound("/nonono.wav");
        lastLife = new Sound("/last_time.wav");

    }


    public void start() {

        while (lives >= 0 || checkBricksAlive(bricks)) {
            System.out.print("");
            if (!moveBall) {

                continue;
            }
            try {
                if (ball.getY() + ball.getDIAMETER() >= Board.HEIGHT) {
                    lives--;
                    livesPic.load(livesImage());
                    livesPic.draw();

                    if(lives==3) {
                        lose1.play(true);
                    }
                    if(lives==2) {
                        lose2.play(true);
                    }
                    if(lives==1) {
                        lastLife.play(true);
                    }
                    if (lives == 0) {
                        break;
                    }

                    ball.reset();
                    paddle.reset();
                    setMoveBall();
                    continue;
                }
                paddle.move();
                ball.move(collision);
                collision.checkBallBrick(ball, bricks);

                Thread.sleep(5);

            } catch (InterruptedException e) {
            }
        }
        System.out.println("fim");
        gameOver.draw();
        setMoveBall();
        while (true) {
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

    public void drawGame() {
        menu.delete();
        board.draw();
        for (int i = 0; i < bricks.length; i++) {
            if (!bricks[i].isDestroyed()) {
                bricks[i].showBrick();
            }
        }
        ball.show();
        paddle.show();
        livesPic.draw();
    }

    public void menu() {
        menu.draw();
        while (!moveBall) {
            System.out.print("");
            continue;
        }
        drawGame();
        startFx.readyGoText();
        start();
    }

    public String livesImage(){
        String a="";
        switch(lives){
            case 4 : a="/4lifes.png";
            break;
            case 3: a ="/3lifes.png";
            break;
            case 2 : a="/2lifes.png";
            break;
            case 1 : a= "/1life.png";
            break;
        }
         return  a;
    }

}
