package Soggetti;

import java.awt.*;

import static Utility.Dati.squareDimension;

public class Boia implements Soggetto{

    //Il boia ammazza tutti quelli che gli sono vicino

    private int x;
    private int y;

    public Boia(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void Disegna(Graphics g){
        g.setColor(Color.magenta);
        g.fillRect(x, y, squareDimension, squareDimension);
    }
}