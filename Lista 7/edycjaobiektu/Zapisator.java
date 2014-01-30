/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edycjaobiektu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author kayne
 */
public class Zapisator {

    FileOutputStream output;

    public void zapiszObiektDoPliku(File plik, Object obiekt) throws IOException {
        FileOutputStream strumień = new FileOutputStream(plik);
        try (ObjectOutputStream os = new ObjectOutputStream(strumień)) {
            os.writeObject(obiekt);
        }
    }

    public Object wczytajObiektZPliku(File plik) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(plik);
        ObjectInputStream os = new ObjectInputStream(fileStream);
        Object one = os.readObject();
        return one;
    }
}
