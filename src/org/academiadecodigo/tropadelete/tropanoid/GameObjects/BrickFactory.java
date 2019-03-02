package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.tropanoid.Board;

public class BrickFactory {

    public static Brick[] CreateBricks(int bricksNumber) {

        int posX = Board.PADDING * 5;
        int posY = posX;
        int spaceX = 1;
        int spaceY = spaceX;

        Brick[] brick = new Brick[bricksNumber];

        for (int i = 0; i < brick.length; i++) {
            brick[i] = new Brick(posX, posY);
            posX += Brick.getWIDTH() + spaceX;

            if (posX + Brick.getWIDTH() > Board.getWIDTH()) {
                posY += Brick.getHEIGHT() + spaceY;
                posX = Board.PADDING * 5;
            }

        }
        return brick;
    }

}
