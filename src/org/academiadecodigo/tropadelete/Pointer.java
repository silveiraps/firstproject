package org.academiadecodigo.tropadelete;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pointer {

    private Rectangle pointer;
    private PointerDirection direction;


    public Pointer() {
        this.pointer = new Rectangle(Board.PADDING, Board.PADDING, Board.SQUARESIZE, Board.SQUARESIZE);
        pointer.draw();
        pointer.fill();

    }


    public void move() {
        if (direction == PointerDirection.UP) {
            this.pointer.translate(0, -Board.SQUARESIZE);
        } else if (direction == PointerDirection.DOWN) {
            this.pointer.translate(0, Board.SQUARESIZE);
        } else if (direction == PointerDirection.LEFT) {
            this.pointer.translate(-Board.SQUARESIZE, 0);
        } else if (direction == PointerDirection.RIGHT) {
            this.pointer.translate(Board.SQUARESIZE, 0);
        } else if (direction == PointerDirection.NULL) {
            this.pointer.translate(0, 0);
        }
    }


    public void setDirection(PointerDirection direction) {
        this.direction = direction;
    }

    public Rectangle getPointer() {
        return pointer;
    }


    public int getX() {
        return pointer.getX();
    }

    public int getY() {
        return pointer.getY();
    }



}