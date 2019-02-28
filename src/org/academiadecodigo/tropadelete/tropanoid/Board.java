package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Ball;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;

public class Board {

    public static final int PADDING = 10;
    public static final int HEIGHT = 640;
    public static final int WIDTH = 480;
    private Paddle paddle;
    private Ball ball;
    private Collision collision;
    private int lifes;


    public Board() {
        Picture picture = new Picture(PADDING,PADDING,"resources/Background.png");
        Rectangle grid = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        picture.draw();
        grid.draw();
        this.paddle = new Paddle();
        this.ball = new Ball();
        this.collision = new Collision(ball,paddle,this);
        this.lifes = 3;
    }

    public void start() {

        while (true) {
            try {
                paddle.move();
                ball.move();
                collision.check();
                if(lifes==0){
                    System.out.println("Game Ended");
                    return;
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

    public int getLifes() {
        return lifes;
    }

    public void loseLife() {
        this.lifes --;
    }
}
