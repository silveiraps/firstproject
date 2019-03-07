package org.academiadecodigo.tropadelete;

import org.academiadecodigo.tropadelete.Board;
import org.academiadecodigo.tropadelete.KeyboardListener;

public class Main {
    public static void main(String[] args) {


        Board board = new Board();
        board.start();
        new KeyboardListener(board,board.getPointer());

    }
}
