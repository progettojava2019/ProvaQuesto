package Soggetti;

import java.awt.*;

import static Utility.Dati.squareDimension;

public class Figlio implements Soggetto {

    private int x;
    private int y;

    public Figlio(int x, int y){
        this.x = x;
        this.y = y;

    }

    @Override
    public void Disegna(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(x, y, squareDimension, squareDimension);
    }
}
