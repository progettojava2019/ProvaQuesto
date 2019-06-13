package Evoluzione;

import Utility.Matrice;
import Utility.MatriceSceriffo;
import Utility.Random;

import static Utility.Dati.*;

public class CreaSoggettiRandom {

    public Matrice creaSoggetti(Matrice mat, int numSoggetti) {

        MatriceSceriffo matriceSceriffo = new MatriceSceriffo();//istanzio un oggetto della classe MatriceSceriffo

        //Non tutta la griglia è inizialmente "abitabile", ma la porzione in cui possono essere presenti i soggetti
        // aumenta a mano mano che la situazione evolve
        int subGridStartW = gridWidth / 2 - widthSubGrid;
        int subGridEndW = gridWidth / 2 + (widthSubGrid - squareDimension);
        int subGridStartH = gridHeigth / 2 - heigthSubGrid;
        int subGridEndH = gridHeigth / 2 + (heigthSubGrid - squareDimension);


        //Viene controllato che il numero di soggetti non superi lo spazio disponibile
        if(SubjectNumber > (widthSubGrid/squareDimension*heigthSubGrid/squareDimension)*4){
            System.out.println("ALERT!!! Sovraffolamento");
            System.exit(-1000);
        } else {
            //Se c'è spazio disponibile, vengono creati tanti soggetti quanti indicati nel secondo argomento della
            // chiamata del metodo
            for (int i = 0; i < numSoggetti; i++) {
                int x = new Random().randomizza(subGridStartW, subGridEndW);//crea la coordinata x del nuovo soggetto (all'interno dell'intervallo definito in input)
                int y = new Random().randomizza(subGridStartH, subGridEndH);//crea la coordinata y del nuovo soggetto (all'interno dell'intervallo definito in input)

                //verifica che il posto assegnato sia disponibile
                boolean controllore = true;
                controllore = new MatriceSceriffo().controlla(x, y, controllore);
                if (controllore) {
                    mat.addRiga(x, y);
                    matriceSceriffo.addRiga(x, y);
                } else {
                    System.out.println("Sono uno sceriffo e ho fatto il mio lavoro");
                    i -= 1;//ripete la procedura
                }
            }
        }
        return mat;
    }
}
