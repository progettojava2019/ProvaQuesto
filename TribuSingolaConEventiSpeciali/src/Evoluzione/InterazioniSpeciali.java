package Evoluzione;

import Grafica.CostruisciGrafico;
import Utility.CalcolaDistanze;
import Utility.Matrice;

import static Utility.Dati.*;

public class InterazioniSpeciali {


    public void effettoDonGiovanni(){

        nascitaGemelli();//quando viene chiamato il metodo effettoDonGiovanni, DonGiovanni e femmine interagiscono

        new CostruisciGrafico();//richiama la classe costruisci grafico
    }


    public void effettoBoia(){

        carneficina();//quando viene chiamato il metodo effettoBoia, DonGiovanni e femmine interagiscono

        new CostruisciGrafico();//richiama la classe costruisci grafico
    }


    public void nascitaGemelli(){

        Matrice mat1 = matriceFemmine;
        Matrice mat2 = matriceDonGiovanni;

        for(int i = 0; i < mat1.getnRigheComplete(); i++) {

            for (int j = 0; j < mat2.getnRigheComplete(); j++) {
                //per ogni coppia femmina-donGiovanni, viene calcolata la distanza
                float distanza = new CalcolaDistanze().distanza(mat1.getElement(i,0), mat1.getElement(i,1), mat2.getElement(j,0), mat2.getElement(j,1));

                //se femmina e DonGiovanni si trovano in posizioni adiacenti...
                if (distanza < distanzaMassima) {
                    //...nasce una coppia di gemelli in posizione random
                    Matrice gemelli = new Matrice(2,2);
                    gemelli = new CreaSoggettiRandom().creaSoggetti(gemelli, 2);
                    matriceFigli.addRiga(gemelli.getElement(0,0), gemelli.getElement(0,1));
                    matriceFigli.addRiga(gemelli.getElement(1,0), gemelli.getElement(1,1));
                }

            }
        }

        matriceDonGiovanni.clearMatrice();//una volta che hanno avuto effetto, i donGiovanni muoiono
    }



    public void carneficina(){

        Matrice mat1 = matriceMaschi;
        Matrice mat2 = matriceBoia;

        for(int k = 0; k < mat1.getnRigheComplete(); k++) {

            for (int kk = 0; kk < mat2.getnRigheComplete(); kk++) {

                //per ogni coppia maschio-boia, viene calcolata la distanza
                float distanza = new CalcolaDistanze().distanza(mat1.getElement(k,0), mat1.getElement(k,1), mat2.getElement(kk,0), mat2.getElement(kk,1));

                if (distanza < distanzaMassima) {
                    //se maschio e boia si trovano in posizioni adiacenti...
                    mat1.removeRiga(k);//...il maschio viene ucciso
                }

            }
        }

        matriceBoia.clearMatrice();//una volta che hanno avuto effetto, i boia muoiono
    }
}
