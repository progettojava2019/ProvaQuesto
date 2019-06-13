package Evoluzione;

import Grafica.CostruisciGrafico;
import Utility.CalcolaDistanze;
import Utility.Matrice;

import static Utility.Dati.*;


public class InterazioneInterSex {

    public InterazioneInterSex(){

        nascitaFigli();//quando viene chiamata la classe InterazioneInterSex, maschi e femmine interagiscono

        new CostruisciGrafico();//richiama la classe costruisci grafico
    }


    public void nascitaFigli(){

        Matrice m = matriceMaschi;
        Matrice f = matriceFemmine;

        //Ogni volata che nasce un figlio l'area disponibile aumenta
        if(widthSubGrid + squareDimension < (gridWidth)/2)
            widthSubGrid += 2 * squareDimension;
        if(heigthSubGrid + squareDimension < (gridHeigth)/2)
            heigthSubGrid += squareDimension;


        for(int i = 0; i < m.getnRigheComplete(); i++) {

            for (int j = 0; j < f.getnRigheComplete(); j++) {

                //per ogni coppia maschio-femmina, viene calcolata la distanza
                float distanzaMF = new CalcolaDistanze().distanza(m.getElement(i,0), m.getElement(i,1), f.getElement(j,0), f.getElement(j,1));

                //se maschio e femmina si trovano in posizioni adiacenti
                if (distanzaMF < distanzaMassima) {

                    //il figlio prende il posto della femmina
                    matriceFigli.addRiga(f.getElement(j,0), f.getElement(j,1));

                    //il maschio viene spostato in posizione random
                    Matrice nuovoMaschio = new Matrice(1,2);
                    nuovoMaschio = new CreaSoggettiRandom().creaSoggetti(nuovoMaschio, 1);
                    matriceMaschi.sosituisciRiga(nuovoMaschio, i);

                    //il maschio viene spostato in posizione random
                    Matrice nuovaFemmina = new Matrice(1,2);
                    nuovaFemmina = new CreaSoggettiRandom().creaSoggetti(nuovaFemmina, 1);
                    matriceFemmine.sosituisciRiga(nuovaFemmina, j);
                }
            }
        }

    }
}
