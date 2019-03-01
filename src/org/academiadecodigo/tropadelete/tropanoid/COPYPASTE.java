/*package org.academiadecodigo.tropadelete.tropanoid;

public class COPYPASTE {

    //from collision
    if (ball.getSpeedX() > 0) {
        System.out.println(ball.getDirection());
        double paddleBallDelta = (ball.getPositionX() + ball.getRADIUS()) - paddle.getPositionX();

        if (paddleBallDelta > 0 && paddleBallDelta <= paddle.getWIDTH() / 3) {

            int index = ball.getDirection().getIndex();

            ball.setDirection(BallDirection.values()[index - 1]);
        }
        if (paddleBallDelta > paddle.getWIDTH()*2/3 && paddleBallDelta <= paddle.getWIDTH()) {

            int index = ball.getDirection().getIndex();

            ball.setDirection(BallDirection.values()[index + 1]);
        }
        ball.changeDirectionY(ball.getDirection());
        System.out.println(ball.getDirection());
    }
}
//from ball
public void changeDirectionX(BallDirection direction) {
    this.direction = direction.getOppositeX();
    speedX = direction.getDeltaX();
    speedY = direction.getDeltaY();
}
    public void changeDirectionY(BallDirection direction) {
        this.direction = direction.getOppositeY();
        speedX = direction.getDeltaX();
        speedY = direction.getDeltaY();
    }*/
