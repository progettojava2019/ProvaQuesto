package Utility;

import static Utility.Dati.*;

public class Matrice {

    private int numRighe;
    private int numColonne;
    private int [][] matrice;

    public int nRigheComplete = 0;

    public Matrice(){
        matrice = new int[gridWidth/squareDimension*gridHeigth/squareDimension][2];
    }

    public Matrice(int numRighe, int numColonne){
        this.numRighe = numRighe;
        this.numColonne = numColonne;
        matrice = new int [numRighe][numColonne];
    }


    //restituisce l'elemento posto alla riga numR e alla colonna numC
    public int getElement(int indexR, int indexC){
        int val;
        if(indexC == 0){
            val = matrice[indexR][0];
        }
        else
            val = matrice[indexR][1];

        return val;
    }


    //restituisce il numero di righe riempite
    public int getnRigheComplete(){
        return nRigheComplete;
    }



    //aggiunge una riga (= due elementi) alla matrice
    public void addRiga(int e0, int e1){
        matrice[nRigheComplete][0] = e0;
        matrice[nRigheComplete][1] = e1;
        nRigheComplete += 1;
    }


    //aggiunge una riga (= due elementi) alla matrice in posizione definita dal terzo input
    public void addRiga(int e0, int e1, int pos){
        nRigheComplete += 1;
        for (int i = nRigheComplete; i >= pos; i--){
            matrice[i+1][0] = matrice[i][0];
            matrice[i+1][1] = matrice[i][1];

        }
        matrice[pos][0] = e0;
        matrice[pos][1] = e1;
    }

    //aggiunge una riga completa alla matrice
    public void addRiga(Matrice riga){
        int el0 = riga.getElement(0,0);
        int el1 = riga.getElement(0,1);
        addRiga(el0, el1);
    }


    //sostituisce la riga data in ingresso a quella in posizione definita nel secondo ingresso
    public void sosituisciRiga(Matrice riga, int pos){
        int elem0 = riga.getElement(0,0);
        int elem1 = riga.getElement(0,1);
        addRiga(elem0, elem1, pos);
        removeRiga(pos+1);
    }


    //rimuove la riga (= un soggetto) alla riga fornita in input
    public void removeRiga(int numRiga){
        for(int i = numRiga; i < nRigheComplete - 1; i++){
            matrice[i][0] = matrice[i+1][0];
            matrice[i][1] = matrice[i+1][1];
        }
        nRigheComplete -= 1;
    }


    //azzera tutta la matrice e il numero di righe riempite
    public void clearMatrice(){
        for (int k = 0; k < nRigheComplete; k++){
            matrice[k][0] = 0;
            matrice[k][1] = 0;
        }
        nRigheComplete = 0;
    }


    //stampa la matrice a video
    public void stampaMatrice(){
        for (int ii = 0; ii<nRigheComplete; ii++){
            for(int jj = 0; jj<2; jj++){
                System.out.print(matrice[ii][jj] + " ");
            }
            System.out.println();
        }
    }

}