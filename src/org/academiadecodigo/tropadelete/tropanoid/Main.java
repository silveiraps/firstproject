package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.tropadelete.tropanoid.Keyboard.KeyboardListener;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        new KeyboardListener(board.getPaddle());
        board.start();
    }
}
