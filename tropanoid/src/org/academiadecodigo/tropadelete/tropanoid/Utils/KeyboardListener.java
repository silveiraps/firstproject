package org.academiadecodigo.tropadelete.tropanoid.Utils;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Paddle;

public class KeyboardListener implements KeyboardHandler {

    private Paddle paddle;

    public KeyboardListener(Paddle paddle) {

        this.paddle = paddle;
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
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                this.paddle.setDirection(PaddleDirection.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:
                this.paddle.setDirection(PaddleDirection.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        this.paddle.setDirection(null);
    }
}
