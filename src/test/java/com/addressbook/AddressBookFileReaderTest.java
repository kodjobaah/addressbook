package com.addressbook;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by kodjobaah on 16/11/2015.
 */
public class AddressBookFileReaderTest {


    private AddressBookFileReader addressBookFileReader;

    @Before
    public void setup() throws FileNotFoundException {

        String fileName = "src/test/resources/AddressBook";
        addressBookFileReader = new AddressBookFileReader(fileName);
    }

    @Test
    public void testReadLine() {
        String line = addressBookFileReader.readLine();
        assertTrue(line.equals("Bill McKnight, Male, 16/03/77"));

    }


    @Test
    public void readFileContent() {
        String line1 = addressBookFileReader.readLine();
        String line2 = addressBookFileReader.readLine();
        String line3 = addressBookFileReader.readLine();
        String line4 = addressBookFileReader.readLine();
        String line5 = addressBookFileReader.readLine();
        String line6 = addressBookFileReader.readLine();
        assertTrue(line1.length() > 0);
        assertTrue(line2.length() > 0);
        assertTrue(line3.length() > 0);
        assertTrue(line4.length() > 0);
        assertTrue(line5.length() > 0);
        assertTrue(line6.length() == 0);

    }
}
