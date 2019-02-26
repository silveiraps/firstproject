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

        if (ball.getX()-RADIUS/4< Board.PADDING || ball.getX() + RADIUS/4 >= Board.getWIDTH()) {
            speedX = -speedX;
        }

        if (ball.getY() <= Board.PADDING) {
            speedY = -speedY;
        }

        positionX +=  speedX;
        positionY +=  speedY;


        ball.translate(positionX - prevPosX, positionY - prevPosY);
        positionX = positionX - prevPosX;
        positionY = positionY - prevPosY;

        show();


        Thread.sleep(5);
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

    public int getRADIUS() {
        return RADIUS;
    }

    public void invertSpeedY() {
        this.speedY = -speedY;
    }

    public int getSpeedY() {
        return speedY;
    }
}
