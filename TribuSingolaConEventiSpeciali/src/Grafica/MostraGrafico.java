package Grafica;

import Soggetti.*;
import Utility.Matrice;

import javax.swing.*;
import java.awt.*;

public class MostraGrafico {

    private Pannello pannello = new Pannello();

    public void riempiGrafico(Matrice mat, String str, MyFrame fr){

        Container c = fr.getContentPane();

        //al pannello vengono aggiunti tutti i soggetti presenti

        if(mat.getnRigheComplete() != 0) {
            for (int i = 0; i < mat.getnRigheComplete(); i++) {
                if (str.equals("Maschi")) {
                    Maschio maschio = new Maschio(mat.getElement(i, 0), mat.getElement(i, 1));
                    pannello.add(maschio);
                } else if (str.equals("Femmine")) {
                    Femmina femmina = new Femmina(mat.getElement(i, 0), mat.getElement(i, 1));
                    pannello.add(femmina);
                } else if (str.equals("Figli")) {
                    Figlio figlio = new Figlio(mat.getElement(i, 0), mat.getElement(i, 1));
                    pannello.add(figlio);
                } else if (str.equals("Don Giovanni")) {
                    DonGiovanni donGiovanni = new DonGiovanni(mat.getElement(i, 0), mat.getElement(i, 1));
                    pannello.add(donGiovanni);
                } else if (str.equals("Boia")) {
                    Boia boia = new Boia(mat.getElement(i, 0), mat.getElement(i, 1));
                    pannello.add(boia);
                }
            }
            c.add(pannello);
        }


        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}