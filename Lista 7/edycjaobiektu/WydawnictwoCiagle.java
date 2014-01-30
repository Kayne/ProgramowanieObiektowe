/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edycjaobiektu;

/**
 *
 * @author kayne
 */
public class WydawnictwoCiagle extends Ksiazka {
    
    protected String adres;
    protected boolean dziala;
    
    public WydawnictwoCiagle() {
        super();
        adres = "";
        dziala = false;
    }
    public WydawnictwoCiagle(String t, String a, String o, String s, boolean dz) {
        super(t, a, o);
        adres = s;
        dziala = dz;
    }
    
    
    public void setAdres(String a) {
        adres = a;
    }
    
    public String getAdres() {
        return adres;
    }
    
    public void setDziala(boolean d) {
        dziala = d;
    }
    
    public boolean getCzyDziala() {
        return dziala;
    }
    
    @Override
    public String toString() {
        return "Nazwa: " + tytul + ", właściciel: " + autor + ", opis: " + opis + ", adres: " + adres + ", czy działa? " + dziala;
    }
    
}
