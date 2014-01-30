/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buforzwatkami;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kayne
 */
public class BuforZWatkami {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Bufor<String> bufor = new Bufor<>(5);
        Thread watekKonsumenta = new Thread(new Konsument(bufor));
        Thread watekProducenta = new Thread(new Producent(bufor));

        watekKonsumenta.start();
        watekProducenta.start();

        try {
            watekKonsumenta.join();
            watekProducenta.join();
        } catch (InterruptedException e) {
        }
    }
}

class Konsument implements Runnable {

    Bufor bufor;

    public Konsument(Bufor dane) {
        bufor = dane;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            try {
                System.out.println(bufor.pobierz());
            } catch (IndexOutOfBoundsException | InterruptedException ex) {
                Logger.getLogger(Konsument.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }
}

class Producent implements Runnable {

    Bufor bufor;

    public Producent(Bufor dane) {
        bufor = dane;
    }

    private String generujTekst() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            try {
                bufor.dodaj(generujTekst());
            } catch (InterruptedException ex) {
                Logger.getLogger(Producent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}