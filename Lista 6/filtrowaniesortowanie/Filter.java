/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrowaniesortowanie;

import buforzwatkami.Bufor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasa filtrująca przekazane dane przekazanym filtrem, i dodająca wyniki do
 * buforu. Jako dane przyjmuje ArrayList<String>, bo zakłada się, że dzielenie
 * danych na wiersze znajduje się w innym miejscu logiki aplikacji.
 *
 * @author kayne
 */
public class Filter implements Runnable {

    Pattern pattern;
    Matcher matcher;
    Bufor bufor;
    ArrayList<String> dane;
    boolean częściowy = false;

    /**
     * Domyślny konstruktor, przyjmujący filtr (pattern), wskaźnik na bufor
     * (Bufor) i dane (ArrayList<String>).
     *
     * @param patternNowy filtr, którym będzie się operować
     * @param buforNowy wskaźnik na bufor, do którego będzie się wrzucać
     * odfiltrowane dane
     * @param daneNowe dane, które należy przefiltrować
     */
    public Filter(String patternNowy, Bufor buforNowy, ArrayList<String> daneNowe) {
        ustawZmienne(patternNowy, buforNowy, daneNowe);
    }

    /**
     * Poszerzony konstruktor, przyjmujący opcjonalnie flagę czy filtrować
     * częściowo czy całościowo dany wiersz (czyli, czy do buforu przesłać całe
     * zdanie jak jej część pasuje czy tylko dopasowaną część).
     *
     * @param patternNowy filtr, którym będzie się operować
     * @param buforNowy wskaźnik na bufor, do którego będzie się wrzucać
     * odfiltrowane dane
     * @param daneNowe dane, które należy przefiltrować
     * @param częściowyNowy flaga, czy filtrować częściowo czy czałościowo
     * wiersz
     */
    public Filter(String patternNowy, Bufor buforNowy, ArrayList<String> daneNowe, boolean częściowyNowy) {
        ustawZmienne(patternNowy, buforNowy, daneNowe);
        częściowy = częściowyNowy;
    }

    /**
     * Ustala wartości zmiennych potrzebnych do działania klasy, przekazywanych
     * w konstruktorze.
     *
     * @param patternNowy filtr, którym będzie się operować
     * @param buforNowy wskaźnik na bufor, do którego będzie się wrzucać
     * odfiltrowane dane
     * @param daneNowe dane, które należy przefiltrować
     */
    private void ustawZmienne(String patternNowy, Bufor buforNowy, ArrayList<String> daneNowe) {
        pattern = Pattern.compile(patternNowy);
        bufor = buforNowy;
        dane = daneNowe;
    }

    /**
     * Główna metoda klasy, filtrująca całe przekazane dane i wrzucająca kolejne
     * wiersze do buforu.
     *
     * @throws InterruptedException
     */
    public void filtruj() throws InterruptedException {
        while (!dane.isEmpty()) {
            String obecne = dane.get(0);
            dane.remove(0);
            matcher = pattern.matcher(obecne);
            if (częściowy) {
                if (matcher.find()) {
                    bufor.dodaj(obecne);
                }
            } else {
                while (matcher.find()) {
                    bufor.dodaj(matcher.group());
                }
            }

        }
    }

    /**
     * Metoda uruchamiająca filtrowanie.
     */
    @Override
    public void run() {
        try {
            filtruj();
        } catch (InterruptedException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
