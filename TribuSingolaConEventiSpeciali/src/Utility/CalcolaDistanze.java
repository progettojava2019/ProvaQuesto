package Utility;

public class CalcolaDistanze {

    public float distanza(int x1, int y1, int x2, int y2){

        float X1 = (float) x1;
        float Y1 = (float) y1;
        float X2 = (float) x2;
        float Y2 = (float) y2;

        float distanza = (float) Math.sqrt( Math.pow(X1 - X2, 2) + Math.pow(Y1 - Y2, 2) );

        return distanza;
    }
}
