package org.academiadecodigo.tropadelete.tropanoid;

public enum BallDirection {
    D_HORIZONTAL(0.9962,-0.0872),
    D_15(0.9659,-0.2588),
    D_30(0.866,-0.5),
    D_45(0.7071,-0.7071),
    D_60(0.5,-0.866),
    D_75(0.2588,-0.9659),
    D_VERTICAL(-0.0872,0.9962);

    private double deltaX;
    private double deltaY;

    BallDirection(double deltaX,double deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public static BallDirection pick() {
        return values()[(int) Math.random()*values().length];
    }

    public double getDeltaX() {
        return deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

}
