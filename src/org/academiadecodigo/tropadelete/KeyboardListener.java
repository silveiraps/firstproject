package org.academiadecodigo.tropadelete;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class KeyboardListener implements KeyboardHandler {

    private Pointer pointer;
    private Board board;

    public KeyboardListener(Board board, Pointer pointer) {

        this.pointer = pointer;
        this.board = board;

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent rightR = new KeyboardEvent();
        rightR.setKey(KeyboardEvent.KEY_RIGHT);
        rightR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(rightR);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent leftR = new KeyboardEvent();
        leftR.setKey(KeyboardEvent.KEY_LEFT);
        leftR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(leftR);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent upR = new KeyboardEvent();
        upR.setKey(KeyboardEvent.KEY_UP);
        upR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(upR);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent downR = new KeyboardEvent();
        downR.setKey(KeyboardEvent.KEY_DOWN);
        downR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(downR);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                this.pointer.setDirection(PointerDirection.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:
                this.pointer.setDirection(PointerDirection.RIGHT);
                break;

            case KeyboardEvent.KEY_DOWN:
                this.pointer.setDirection(PointerDirection.DOWN);
                break;

            case KeyboardEvent.KEY_UP:
                this.pointer.setDirection(PointerDirection.UP);
                break;

            case KeyboardEvent.KEY_SPACE:
                this.pointer.setDirection(PointerDirection.NULL);
                board.paint();
                break;
        }
        pointer.move();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

       /* switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                this.pointer.removePaint();*/


        // }
        //this.pointer.setDirection(PointerDirection.NULL);
    }
}
