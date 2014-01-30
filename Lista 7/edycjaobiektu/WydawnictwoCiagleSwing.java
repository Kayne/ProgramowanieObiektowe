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
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kayne
 */
public class WydawnictwoCiagleSwing extends JPanel {

    JPanel panel;
    JFileChooser jfile = new JFileChooser();

    public WydawnictwoCiagleSwing(final WydawnictwoCiagle wydawnictwo) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel myLabel = new JLabel("Tytuł:");
        panel.add(myLabel);

        final JTextField tytulField = new JTextField(wydawnictwo.tytul);
        panel.add(tytulField);

        myLabel = new JLabel("Autor:");
        panel.add(myLabel);

        final JTextField autorField = new JTextField(wydawnictwo.autor);
        panel.add(autorField);

        myLabel = new JLabel("Opis:");
        panel.add(myLabel);

        final JTextField opisField = new JTextField(wydawnictwo.opis);
        panel.add(opisField);

        myLabel = new JLabel("Adres:");
        panel.add(myLabel);

        final JTextField adresField = new JTextField(wydawnictwo.adres);
        panel.add(adresField);

        myLabel = new JLabel("Działa?");
        panel.add(myLabel);

        final JCheckBox dzialaCheckBox;
        if (wydawnictwo.getCzyDziala()) {
            dzialaCheckBox = new JCheckBox("", true);
        } else {
            dzialaCheckBox = new JCheckBox(wydawnictwo.adres);
        }

        panel.add(dzialaCheckBox);

        JButton myButton = new JButton("Zapisz");
        myButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (jfile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        File outputfile = jfile.getSelectedFile();

                        wydawnictwo.setTytul(tytulField.getText());
                        wydawnictwo.setAutor(autorField.getText());
                        wydawnictwo.setOpis(opisField.getText());
                        wydawnictwo.setAdres(adresField.getText());
                        wydawnictwo.setDziala(dzialaCheckBox.isSelected());

                        Zapisator zapis = new Zapisator();
                        zapis.zapiszObiektDoPliku(outputfile, wydawnictwo);
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
                        WydawnictwoCiagle wydawnictwo = (WydawnictwoCiagle) zapis.wczytajObiektZPliku(outputfile);

                        tytulField.setText(wydawnictwo.getTytul());
                        autorField.setText(wydawnictwo.getAutor());
                        opisField.setText(wydawnictwo.getOpis());
                        adresField.setText(wydawnictwo.getAdres());
                        dzialaCheckBox.setSelected(wydawnictwo.getCzyDziala());
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
