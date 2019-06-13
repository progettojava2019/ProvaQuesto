package Soggetti;

import java.awt.*;

import static Utility.Dati.squareDimension;

public class Maschio implements Soggetto {

    private int x;
    private int y;
    //private int dimension;

    public Maschio(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void Disegna(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, squareDimension, squareDimension);
    }

}