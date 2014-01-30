/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrowaniesortowanie;

import buforzwatkami.Bufor;
import java.util.ArrayList;

/**
 *
 * @author kayne
 */
public class FiltrowanieSortowanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bufor<String> bufor = new Bufor<>(1);

        // Symulowanie obróbki danych
        ArrayList<String> dane = new ArrayList();
        dane.add("Tylko");
        dane.add("ktos niewazny");
        dane.add("Adam Stary");
        dane.add("Kamil Nowy");
        dane.add("Zebra Ładna");
        dane.add("Francja Podbita");
        dane.add("Środa Wolna");
        dane.add("Czwartek Cisco");
        dane.add("Ktokolwiek Niemy");
        dane.add("Jezus Chrystus");
        dane.add("Jezus Chrystus");
        dane.add("Adam Nowy");
        dane.add("Adam Taki i Owaki");
        dane.add("");

        //Filter filter = new Filter("^[A-Z][a-ząęśćńółżź]+$", bufor);
        Filter filter = new Filter("Adam [A-Z][a-z]*", bufor, dane, true);

        Sorter sorter = new Sorter(bufor);


        Thread watekFiltra = new Thread(filter);
        Thread watekSortera = new Thread(sorter);


        watekFiltra.start();
        watekSortera.start();

        try {
            watekFiltra.join();
            if (!watekFiltra.isAlive()) {
                watekSortera.interrupt();
            }
            watekSortera.join();
        } catch (InterruptedException e) {
        }

    }
}
