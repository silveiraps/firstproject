package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.tropadelete.tropanoid.Board;

public class Ball extends GameObjects {

    private final int RADIUS = 10;

    private int positionX;
    private int positionY;
    private int speedX;
    private int speedY;
    private Ellipse ball;

    public Ball() {

        positionX = (Board.getWIDTH() - RADIUS) / 2;
        positionY = Board.getHEIGHT() - RADIUS;
        speedX = (int) Math.ceil(Math.random() * 3);
        speedY = -1;

        ball = new Ellipse(positionX, positionY, RADIUS, RADIUS);
        show();
    }
    public Ball(Ball ball) {

        positionY = ball.positionY;
        positionX = ball.positionX;
    }

    public void move() throws InterruptedException {

        int prevPosX = positionX;
        int prevPosY = positionY;

        positionX += 5*speedX;
        positionY += 5*speedY;

        ball.translate(positionX-prevPosX,positionY-prevPosY);

        show();


        Thread.sleep(10);
        // System.out.println("x"+positionX);
        // System.out.println("y"+positionY);
    }

    public void show() {

        ball.draw();
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
