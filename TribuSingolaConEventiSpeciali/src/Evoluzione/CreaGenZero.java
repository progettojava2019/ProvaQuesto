package Evoluzione;

import Grafica.CostruisciGrafico;

import static Utility.Dati.*;

public class CreaGenZero {


    public CreaGenZero(){

        //SubjectNumber è definito in Utility.Dati
        int numMaschiIniziali = SubjectNumber/2;//numero di maschi iniziali è pari alla metà dei soggetti iniziali
        int numFemmineIniziali = SubjectNumber/2;//numero di femmine iniziali è pari alla metà dei soggetti iniziali

        CreaSoggettiRandom crea = new CreaSoggettiRandom();//istanzia un oggetto della classe CreaSoggettiRandom
        crea.creaSoggetti(matriceMaschi, numMaschiIniziali);//esegue il metodo creaSoggetti nella classe CreaSoggettiRandom
        crea.creaSoggetti(matriceFemmine, numFemmineIniziali);//esegue il metodo creaSoggetti nella classe CreaSoggettiRandom

        new CostruisciGrafico();//richiama la classe costruisci grafico

    }


}
