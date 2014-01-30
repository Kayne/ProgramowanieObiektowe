/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buforzwatkami;

import java.util.ArrayList;

/**
 *
 * @author kayne
 */
public class Bufor<T> {
    
    final ArrayList<T> dane = new ArrayList<>();
    int rozmiarBuforu;
    
    public Bufor(int rozmiar) {
        rozmiarBuforu = rozmiar;
    }
    
    public synchronized void dodaj(T element) throws InterruptedException {
        if (dane.size() > rozmiarBuforu) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        dane.add(element);
        notify();
    }
    
    public synchronized T pobierz() throws IndexOutOfBoundsException, InterruptedException {
        if (dane.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        T temp = dane.get(0);
        dane.remove(0);
        notify();
        return temp;
    }
    
    public synchronized boolean jestPusty() {
        if (dane.isEmpty()) {
            return true;
        }
        return false;
    }
}
