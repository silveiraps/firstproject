package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameObjects {

    private Color color;
    private int positionX;
    private int positionY;
    private boolean showing;
    private Rectangle shape;

    protected void show() {
        this.shape.fill();
    }

}
