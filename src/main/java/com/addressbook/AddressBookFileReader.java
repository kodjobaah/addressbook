package com.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kodjobaah on 16/11/2015.
 */
public class AddressBookFileReader {


    FileReader reader = null;

    public AddressBookFileReader(String fileName) throws FileNotFoundException {
        reader = new FileReader(new File(fileName));
    }

    public String readLine() {

        int data = 0;
        char value = '\0';
        StringBuilder line = new StringBuilder();
        try {
            do {
                data = reader.read();
                if (data != -1) {
                    value = (char) data;
                    if (value != '\n')
                        line.append(value);
                }

            } while ((value != '\n') && (data != -1));

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return line.toString();
    }

}
