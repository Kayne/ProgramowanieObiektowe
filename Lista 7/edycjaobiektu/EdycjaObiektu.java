/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edycjaobiektu;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author kayne
 */
public class EdycjaObiektu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Ksiazka jakas = new Ksiazka();
        WydawnictwoCiagle wydawnictwo = new WydawnictwoCiagle();

        JFrame frame = new JFrame("Edycja książki");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        Container kontener = frame.getContentPane();
        GridLayout layout = new GridLayout(1, 0);
        kontener.setLayout(layout);

        KsiazkaSwing edycja = new KsiazkaSwing(jakas);

        kontener.add(edycja);

        WydawnictwoCiagleSwing edycja_2 = new WydawnictwoCiagleSwing(wydawnictwo);

        kontener.add(edycja_2);

        frame.pack();
        frame.setVisible(true);
    }
}
