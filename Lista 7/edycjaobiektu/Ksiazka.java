/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edycjaobiektu;

import java.io.Serializable;

/**
 *
 * @author kayne
 */
public class Ksiazka implements Serializable {
    
    protected String tytul;
    protected String autor;
    protected String opis;
    
    public Ksiazka() {
        tytul = "";
        autor = "";
        opis = "";
    }
    public Ksiazka(String t, String a, String o) {
        tytul = t;
        autor = a;
        opis = o;
    }
    
    public void setTytul(String t) {
        tytul = t;
    }
    
    public String getTytul() {
        return tytul;
    }
    
    public void setAutor(String a) {
        autor = a;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setOpis(String o) {
        opis = o;
    }
    
    public String getOpis() {
        return opis;
    }
    
    @Override
    public String toString() {
        return "Tytuł: " + tytul + ", autor: " + autor + ", opis: " + opis;
    }

}
