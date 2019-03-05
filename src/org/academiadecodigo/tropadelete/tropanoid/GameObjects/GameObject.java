package org.academiadecodigo.tropadelete.tropanoid.GameObjects;

public abstract class GameObject {

    protected double x;
    protected double y;
    protected int imageWidth;
    protected int imageHeight;

    public int getImageHeight() {
        return imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
