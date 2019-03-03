package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.tropanoid.Keyboard.KeyboardListener;

public class Main {
    public static void main(String[] args){

        Board board = new Board();
        new KeyboardListener(board.getPaddle());
        board.start();

    }
}
