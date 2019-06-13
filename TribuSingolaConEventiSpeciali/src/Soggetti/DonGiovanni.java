package Soggetti;

import java.awt.*;

import static Utility.Dati.squareDimension;

public class DonGiovanni implements Soggetto{

    private int x;
    private int y;

    public DonGiovanni(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void Disegna(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(x, y, squareDimension, squareDimension);
    }

}

