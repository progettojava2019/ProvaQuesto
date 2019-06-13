package Utility;

import static Utility.Dati.squareDimension;

public class Random {

    public int randomizza(int valMinimo, int valMassimo){

        int range = valMassimo - valMinimo + 1;

        int rand = (int) (Math.random() * range) + valMinimo;

        if (rand % squareDimension != 0) {
            if (rand % squareDimension > squareDimension / 2)
                rand = rand - rand % squareDimension + squareDimension;
            else
                rand = rand - rand % squareDimension;
        }
        return rand;
    }
}
