package com.addressbook;

import java.io.*;

/**
 * Created by kodjobaah on 16/11/2015.
 */
public class AddressBookFileReader {


    BufferedReader bufferedReader = null;
    FileReader reader = null;
    public AddressBookFileReader(String fileName) throws FileNotFoundException {
        reader = new FileReader(new File(fileName));
        bufferedReader = new BufferedReader(reader);
    }

    public String readLine() {

        String line = null;
        try {
            line = bufferedReader.readLine();


            if (line == null) {
                reader.close();
                return "";
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }


        return line;
    }

}
