package org.academiadecodigo.tropadelete.tropanoid.Utils;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tropadelete.tropanoid.Board;
import org.academiadecodigo.tropadelete.tropanoid.GameObjects.Brick;

public class BrickFactory {

    public static Brick[] CreateBricks(int bricksNumber) {

        int posX = Board.PADDING * 5;
        int posY = posX;
        int spaceX = 3;
        int spaceY = spaceX;

        Brick[] brick = new Brick[bricksNumber];

        for (int i = 0; i < brick.length; i++) {



            brick[i] = new Brick(posX, posY, i % 3 == 0 ? Color.GREEN:Color.BLUE);
            posX += Brick.getWIDTH() + spaceX;

            if (posX + Brick.getWIDTH() > Board.WIDTH) {
                posY += Brick.getHEIGHT() + spaceY;
                posX = Board.PADDING * 5;
            }

        }
        return brick;
    }

}
