/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edycjaobiektu;

/**
 *
 * @author kayne
 */
public class Czasopismo extends Ksiazka {
    
    String gatunek;
    
    public Czasopismo(String t, String a, String o, String g) {
        super(t, a, o);
        gatunek = g;
    }
}
