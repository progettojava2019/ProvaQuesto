package Evoluzione;

import Grafica.CostruisciGrafico;
import Utility.Matrice;

import static Utility.Dati.*;
import static Utility.Dati.matriceMaschi;

public class CrescitaFigli {


    public CrescitaFigli() {

        if (matriceFigli.getnRigheComplete() > 0) {//se esistono figli...
            crescita(matriceFigli);//...viene chiamato il metodo crescita sulla matrice dei figli
        } else {//altrimenti...
            nuovaEra = true;//...inizia una nuova era (nella classe Simulazione vengono creati DonGiovanni e Boia)
        }

        new CostruisciGrafico();////richiama la classe costruisci grafico
    }


    public void crescita (Matrice figli){

        for (int i = 0; i < figli.getnRigheComplete(); i++){
            //Ogni figlio nato può diventare...
            double random = Math.random();
            //...femmina con il 30% di probabilità
            if(random <= 0.3) {
                matriceFemmine.addRiga(figli.getElement(i, 0), figli.getElement(i, 1));
            } else{
                //...maschio con il 70% di probabilità
                matriceMaschi.addRiga(figli.getElement(i, 0), figli.getElement(i, 1));
            }
        }
    }


}
