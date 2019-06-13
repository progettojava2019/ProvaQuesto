import Evoluzione.*;

import static Utility.Dati.*;


public class Simulazione extends Thread{

    public Simulazione() {

        System.out.println("Creazione popolazione");
        new CreaGenZero(); // crea la popolazione iniziale, composta da un numero pari di maschi e femmine

        Thread t = new Thread(this, "Primo Thread");//istanzia un thread
        t.run();//lancia il thread

    }



    @Override
    public void run(){
        try {

            while (true) {

                System.out.println("Interazione tra maschi e femmine");
                new InterazioneInterSex();//interazione tra soggetti di sesso diverso
                Thread.sleep(150);

                System.out.println("Interazione tra maschi e tra femmine");
                new InterazioneIntraSex();//interazione tra soggetti dello stesso sesso
                Thread.sleep(150);

                System.out.println("Crescita figli");
                new CrescitaFigli();//in maniera random i figli diventano maschi o femmine
                if (matriceFigli.getnRigheComplete() > 0){
                    Thread.sleep(150);
                    matriceFigli.clearMatrice();//una volta che i figli sono cresciuti, la matrice deve essere azzerata
                }

                if(nuovaEra){//se non nascono più figli nuovaEra switcha su true
                    System.out.println("Ingresso donGiovanni");
                    new IngressiSpeciali().donGiovanni();//entrano in gioco i don giovanni
                    Thread.sleep(1000);

                    System.out.println("Ingresso Boia");
                    new IngressiSpeciali().boia();//entrano in gioco i boia
                    Thread.sleep(1000);

                    nuovaEra = false;//nuova era torna a false
                }


                if(matriceDonGiovanni.getnRigheComplete() != 0){//se esistono donGiovanni...
                    System.out.println("Interazione tra DonGiovanni e femmine");
                    new InterazioniSpeciali().effettoDonGiovanni();//...interagiscono con le femmine
                    Thread.sleep(300);
                }

                if(matriceBoia.getnRigheComplete() != 0){//se esistono boia...
                    System.out.println("Interazione tra Boia e Soggetti");
                    new InterazioniSpeciali().effettoBoia();//...interagiscono con i maschi
                    Thread.sleep(300);
                }

            }

        } catch (Exception e) {
            System.out.println("Thread ha lanciato un'eccezione");
        }

    }



}
