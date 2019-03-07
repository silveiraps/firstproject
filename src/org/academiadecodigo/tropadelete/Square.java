package org.academiadecodigo.tropadelete;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.awt.*;

public class Square {

    private Rectangle square;
    private boolean isPainted;

    public Square(int startpointX, int starpointY, int sizeX, int sizeY){
        this.square=new Rectangle(startpointX, starpointY,sizeX,sizeY);
        this.isPainted=false;
    }


    public void setPainted() {
        isPainted = true;
    }

    public void setNotPainted(){
        isPainted = false;
    }

    public boolean isPainted(){
        return isPainted;
    }

    public void show(){
        square.draw();
    }

    public void hide(){
        square.draw();
    }

    public void paint(){
        square.fill();
    }

    public int getX(){
        return square.getX();
    }

    public int getY(){
        return square.getY();
    }

}
