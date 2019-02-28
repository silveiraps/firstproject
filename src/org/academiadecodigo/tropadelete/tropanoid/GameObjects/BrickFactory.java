package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tropadelete.tropanoid.Board;

public class BrickFactory {

    public static Brick[] CreateBricks(int bricksNumber) {

        int posX = Board.PADDING;
        int posY = Board.PADDING;
        int spaceX = 1;
        int spaceY = spaceX;

        Brick[] brick = new Brick[bricksNumber];

        for (int i = 0; i < brick.length; i++) {
            brick[i] = new Brick(posX, posY, Color.BLUE);
            posX += Brick.getWIDTH() + spaceX;
            if (posX + Brick.getWIDTH() > Board.getWIDTH()) {
                posY += Brick.getHEIGHT() + spaceY;
                posX = Board.PADDING;
            }

        }
        return brick;
    }

}
