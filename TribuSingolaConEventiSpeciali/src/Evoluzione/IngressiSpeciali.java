package Evoluzione;

import Grafica.CostruisciGrafico;

import static Utility.Dati.*;

public class IngressiSpeciali {


    public void donGiovanni(){

        int nFemmine = matriceFemmine.getnRigheComplete();
        //Il numero di Don Giovanni è pari al numero di femmine presenti diviso 5
        int numeroDonGiovanni = Math.round(nFemmine/5);


        for(int i = 0; i < numeroDonGiovanni; i++) {
            //ogni DonGiovanni viene posto alla destra di una femmina
            int nuovoDonGiovanniX = (matriceFemmine.getElement(i,0) );
            int nuovoDonGiovanniY = matriceFemmine.getElement(i,1) + squareDimension;
            matriceDonGiovanni.addRiga(nuovoDonGiovanniX, nuovoDonGiovanniY);
        }

        new CostruisciGrafico();//richiama la classe costruisci grafico
    }



    public void boia(){

        //Il numero di Boia è pari al numero di maschi presenti diviso 10
        int numeroMaschi =  matriceMaschi.getnRigheComplete();
        int numeroBoia = Math.round(numeroMaschi/8);

        for(int j = 0; j < numeroBoia; j++) {
            //ogni Boia viene posto alla destra di un maschio
            int nuovoBoiaX = (matriceMaschi.getElement(j,0));
            int nuovoBoiaY;
            if(j%2 == 0)
                nuovoBoiaY = (matriceMaschi.getElement(j,1)) - squareDimension;
            else
                nuovoBoiaY = (matriceMaschi.getElement(j,1)) + squareDimension;

            matriceBoia.addRiga(nuovoBoiaX, nuovoBoiaY);
        }

        new CostruisciGrafico();//richiama la classe costruisci grafico
    }



}

