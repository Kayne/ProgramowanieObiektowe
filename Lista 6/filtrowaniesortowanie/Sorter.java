/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrowaniesortowanie;

import buforzwatkami.Bufor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa pobierająca dane z buforu i dodająca w odpowiednie miejsce danych
 * wyjściowych. Po skończeniu pracy, wyświetla wynik na konsoli.
 *
 * @author kayne
 */
public class Sorter implements Runnable {

    Bufor<String> bufor;
    String aktualne;
    ArrayList<String> dane = new ArrayList();
    Boolean pracuj = true;

    /**
     * Konstruktor ustawiający tylko wskaźnik na bufor.
     *
     * @param buforNowy wskaźnik na bufor, z którego będą pobierane odfiltrowane
     * dane
     */
    public Sorter(Bufor buforNowy) {
        bufor = buforNowy;
    }

    /**
     * Główna metoda klasy, pobierająca kolejne dane z buforu i dodająca do
     * danych wyjśćiowych. Tak długo, jak może pobierać dane z buforu (i bufor
     * jest wciąż w użyciu), tak długo będzie pobierać kolejne wiersze.
     *
     * @throws IndexOutOfBoundsException
     * @throws InterruptedException
     */
    public void sortuj() throws IndexOutOfBoundsException, InterruptedException {
        aktualne = pobierzZBuforu();
        if (aktualne != null) {
            int i = 0;
            if (dane.isEmpty()) {
                dane.add(aktualne);
            } else {
                while (dane.get(i).compareTo(aktualne) > 0) {
                    i++;
                    if (i >= dane.size()) {
                        break;
                    }
                }
                dane.add(i, aktualne);
            }
        }
    }

    /**
     * Pobiera kolejne dane z buforu i zwraca je. W przypadku niemożności
     * pobrania z buforu (bo został np. zamknięty), przerywa działanie sortera
     * ustawiając flagę pracuj na false.
     *
     * @return pobrany z buforu odfiltrowany element
     * @throws IndexOutOfBoundsException
     */
    private String pobierzZBuforu() throws IndexOutOfBoundsException {
        String wynik = null;
        try {
            wynik = bufor.pobierz();
        } catch (InterruptedException ex) {
            pracuj = false;
        }
        return wynik;
    }

    /**
     * Zwraca dane z ArrayList<String>.
     *
     * @return dane z ArrayList<String> w formacie toString()
     */
    @Override
    public String toString() {

        return dane.toString();
    }

    /**
     * Metoda uruchamiająca sortowanie. Na koniec wyświetla w konsoli wynik.
     */
    @Override
    public void run() {
        while (!bufor.jestPusty() || pracuj) {
            try {
                sortuj();
            } catch (IndexOutOfBoundsException | InterruptedException ex) {
                Logger.getLogger(Sorter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Collections.reverse(dane);
        System.out.println(toString());
    }
}
