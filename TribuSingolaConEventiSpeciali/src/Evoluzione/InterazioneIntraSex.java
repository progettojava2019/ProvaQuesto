package Evoluzione;

import Grafica.CostruisciGrafico;
import Utility.CalcolaDistanze;
import Utility.Matrice;

import static Utility.Dati.*;

public class InterazioneIntraSex {

    public InterazioneIntraSex(){
        //quando viene chiamata la classe InterazioneIntraSex...
        lottaSoggetti(matriceMaschi, "Maschi");//...i maschi interagiscono tra loro...
        lottaSoggetti(matriceFemmine, "Femmine");//...e le femmine interagiscono tra loro

        new CostruisciGrafico();//richiama la classe costruisci grafico
    }


    public void lottaSoggetti(Matrice mat, String s){
        for(int i = 0; i < mat.getnRigheComplete(); i++) {
            for (int j = 0; j < mat.getnRigheComplete(); j++) {

                //per ogni coppia maschio-maschio/femmina-femmina, viene calcolata la distanza
                float distanza = new CalcolaDistanze().distanza(
                        mat.getElement(i,0), mat.getElement(i,1), mat.getElement(j,0), mat.getElement(j,1));

                if(i != j && distanza < distanzaMassima){
                    //se due maschi o due femmine si trovano vicini...
                    if(s.equals("Maschi")){
                        //...si uccidono
                        matriceMaschi.removeRiga(i);
                        matriceMaschi.removeRiga(j-1);
                        i -= 1;
                        break;
                    }
                    else{
                        //...si uccidono
                        matriceFemmine.removeRiga(i);
                        matriceFemmine.removeRiga(j-1);
                        i -= 1;
                        break;
                    }

                }

            }
        }
    }

}
