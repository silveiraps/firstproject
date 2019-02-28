package org.academiadecodigo.tropadelete.tropanoid.Utils;

public enum BallDirection {

    //UL_5(-0.9962,-0.0872),
    UL_15(-0.9659,-0.2588),
    UL_30(-0.866,-0.5),
    UL_45(-0.7071,-0.7071),
    UL_60(-0.5,-0.866),
    UL_75(-0.2588,-0.9659),
    UL_85(-0.0872,-0.9962),
    UR_85(0.0872,-0.9962),
    UR_75(0.2588,-0.9659),
    UR_60(0.5,-0.866),
    UR_45(0.7071,-0.7071),
    UR_30(0.866,-0.5),
    UR_15(0.9659,-0.2588),
    //UR_5(0.9962,-0.0872),
    //DR_5(0.9962,0.0872),
    DR_15(0.9659,0.2588),
    DR_30(0.866,0.5),
    DR_45(0.7071,0.7071),
    DR_60(0.5,0.866),
    DR_75(0.2588,0.9659),
    DR_85(0.0872,0.9962),
    DL_85(-0.0872,0.9962),
    DL_75(-0.2588,0.9659),
    DL_60(-0.5,0.866),
    DL_45(-0.7071,0.7071),
    DL_30(-0.866,0.5),
    DL_15(-0.9659,0.2588);
    //DL_5(-0.9962,0.0872);

    private double deltaX;
    private double deltaY;

    BallDirection(double deltaX,double deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public static BallDirection pick() {
        return values()[(int) (Math.random()*values().length/2)];
    }

    public BallDirection getOppositeX() {
        switch(this) {
           // case DL_5: return DR_5;
            case DL_15:return DR_15;
            case DL_30:return DR_30;
            case DL_45:return DR_45;
            case DL_60:return DR_60;
            case DL_75:return DR_75;
            case DL_85:return DR_85;
           // case DR_5: return DL_5;
            case DR_15:return DL_15;
            case DR_30:return DL_30;
            case DR_45:return DL_45;
            case DR_60:return DL_60;
            case DR_75:return DL_75;
            case DR_85:return DL_85;
            //case UL_5: return UR_5;
            case UL_15:return UR_15;
            case UL_30:return UR_30;
            case UL_45:return UR_45;
            case UL_60:return UR_60;
            case UL_75:return UR_75;
            case UL_85:return UR_85;
            //case UR_5: return UL_5;
            case UR_15:return UL_15;
            case UR_30:return UL_30;
            case UR_45:return UL_45;
            case UR_60:return UL_60;
            case UR_75:return UL_75;
            case UR_85:return UL_85;
        }
        return null;
    }

    public BallDirection getOppositeY() {
        switch(this) {
           // case DL_5: return UL_5;
            case DL_15:return UL_15;
            case DL_30:return UL_30;
            case DL_45:return UL_45;
            case DL_60:return UL_60;
            case DL_75:return UL_75;
            case DL_85:return UL_85;
           // case DR_5: return UR_5;
            case DR_15:return UR_15;
            case DR_30:return UR_30;
            case DR_45:return UR_45;
            case DR_60:return UR_60;
            case DR_75:return UR_75;
            case DR_85:return UR_85;
           // case UL_5: return DL_5;
            case UL_15:return DL_15;
            case UL_30:return DL_30;
            case UL_45:return DL_45;
            case UL_60:return DL_60;
            case UL_75:return DL_75;
            case UL_85:return DL_85;
            //case UR_5: return DR_5;
            case UR_15:return DR_15;
            case UR_30:return DR_30;
            case UR_45:return DR_45;
            case UR_60:return DR_60;
            case UR_75:return DR_75;
            case UR_85:return DR_85;
        }
        return null;
    }

    public int getIndex() {
        for( int i=0; i< values().length; i++) {
            if ( this == values()[i]) {
                return i;
            }
        }
        return -1;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

    public BallDirection getNext(int value) {
        int i;
        if(value > 0) {
            for (i = 0; i < values().length; i++) {
                if (i + value >= values().length && this == values()[i]) {
                    return values()[values().length-1];
                }
                if (this == values()[i]) {
                    return values()[i + value];
                }
            }
        }
        if (value < 0 ) {
            for (i = 0; i < values().length; i++) {
                if( i + value <= 0 && this == values()[i]) {
                    return values()[0];
                }
                if(this == values()[i]) {
                    return values()[i + value];
                }
            }
        }
        System.out.println("getnext null");
        return null;
    }
}
