package org.academiadecodigo.tropadelete;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Board {

    public static final int PADDING = 10;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int SQUARESIZE = 25;
    private Rectangle mainRectangle;
    private Pointer pointer;
    private Square[] squares;
    private int squareXPosition = PADDING;
    private int squareYPosition = PADDING;


    public Board() {
        mainRectangle = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        squares = new Square[(WIDTH / SQUARESIZE) * (HEIGHT / SQUARESIZE)];
    }


    public void start() {
        int squareCounter = 0;
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square(squareXPosition, squareYPosition, SQUARESIZE, SQUARESIZE);
            squares[i].show();
            squareXPosition += SQUARESIZE;
            squareCounter++;
            if (squareCounter == WIDTH / SQUARESIZE) {
                squareYPosition += SQUARESIZE;
                squareXPosition = PADDING;
                squareCounter = 0;
            }

            pointer = new Pointer();
        }
    }


    public void paint() {
        for (int i = 0; i < squares.length; i++) {

            if (squares[i].getX() == pointer.getX() && squares[i].getY() == pointer.getY()) {
                if (squares[i].isPainted()) {
                    squares[i].hide();
                    squares[i].show();
                    squares[i].setNotPainted();
                    return;

                }
                squares[i].paint();
                squares[i].setPainted();

            }
        }
    }


    public Pointer getPointer() {
        return pointer;
    }
}
