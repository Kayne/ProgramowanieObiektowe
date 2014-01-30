/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edycjaobiektu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kayne
 */
public class KsiazkaSwing extends JPanel {

    JPanel panel;
    JFileChooser jfile = new JFileChooser();

    public KsiazkaSwing(final Ksiazka ksiazka) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel myLabel = new JLabel("Tytuł:");
        panel.add(myLabel);

        final JTextField tytulField = new JTextField(ksiazka.tytul);
        panel.add(tytulField);

        myLabel = new JLabel("Autor:");
        panel.add(myLabel);

        final JTextField autorField = new JTextField(ksiazka.autor);
        panel.add(autorField);

        myLabel = new JLabel("Opis:");
        panel.add(myLabel);

        final JTextField opisField = new JTextField(ksiazka.opis);
        panel.add(opisField);

        JButton myButton = new JButton("Zapisz");
        myButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (jfile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        File outputfile = jfile.getSelectedFile();

                        ksiazka.setTytul(tytulField.getText());
                        ksiazka.setAutor(autorField.getText());
                        ksiazka.setOpis(opisField.getText());

                        Zapisator zapis = new Zapisator();
                        zapis.zapiszObiektDoPliku(outputfile, ksiazka);
                    } catch (IOException ex) {
                        Logger.getLogger(KsiazkaSwing.class.getName()).log(Level.SEVERE, "Wystąpił błąd podczas przetwarzania pliku. Na pewno wybrałeś poprawny plik?", ex);
                    }
                }
            }
        });
        panel.add(myButton);

        JButton myButton2 = new JButton("Wczytaj");
        myButton2.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if (jfile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        Zapisator zapis = new Zapisator();

                        File outputfile = jfile.getSelectedFile();
                        Ksiazka ksiazka = (Ksiazka) zapis.wczytajObiektZPliku(outputfile);

                        tytulField.setText(ksiazka.getTytul());
                        autorField.setText(ksiazka.getAutor());
                        opisField.setText(ksiazka.getOpis());
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(KsiazkaSwing.class.getName()).log(Level.SEVERE, "Wystąpił błąd podczas przetwarzania pliku. Na pewno wybrałeś poprawny plik?", ex);
                    }
                }
            }
        });
        panel.add(myButton2);

        add(panel);

    }
}
