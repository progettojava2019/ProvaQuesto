package Utility;

public final class Dati {

    public static final int gridHeigth = 600;//altezza della Griglia
    public static final int gridWidth = 1200;//larghezza della Griglia
    public static final int squareDimension = 10; //dimensioni del singolo quadratino della grglia


    public static int heigthSubGrid = (gridHeigth/12); //altezza di ciascuna porzione (1/4) della sottogriglia
    public static int widthSubGrid = 2 * heigthSubGrid; //larghezza di ciascuna porzione (1/4) della sottogriglia
    public static final int SubjectNumber = 120; //numero massimo = heigthSubGrid/squareDimension * widthSubGrid/squareDimension

    public static boolean nuovaEra = false;


    public static double distanzaMassima = squareDimension * Math.sqrt(2); //distanza oltre la quale i soggetti non interagiscono tra loro


    /*  Inzializzo le matrice di Maschi, Femmine e Figli  */

    public final static Matrice matriceMaschi = new Matrice(gridWidth/squareDimension*gridHeigth/squareDimension, 2);

    public final static Matrice matriceFemmine = new Matrice(gridWidth/squareDimension*gridHeigth/squareDimension, 2);

    public final static Matrice matriceFigli = new Matrice(gridWidth/squareDimension*gridHeigth/squareDimension, 2);

    public final static Matrice matriceDonGiovanni = new Matrice(gridWidth/squareDimension*gridHeigth/squareDimension, 2);

    public final static Matrice matriceBoia = new Matrice(gridWidth/squareDimension*gridHeigth/squareDimension, 2);


}