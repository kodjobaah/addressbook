package com.addressbook;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by kodjobaah on 16/11/2015.
 */
public class AddressBookTest {


    private AddressBook addresssBook;

    @Before
    public void setup() throws FileNotFoundException {

        String filename= "src/test/resources/AddressBook";
        addresssBook  = new AddressBook(filename);
    }

    @Test
    public void testBuildAddressBook() {

        List<Address> addresses = addresssBook.buildAddressBook();
        assertTrue(addresses.size() == 5);

    }

    @Test
    public void howManyMalesInAddressBook() {
        List<Address> addresses = addresssBook.buildAddressBook();
        Integer numOfMails = addresssBook.getNumberOfMales();

        assertEquals(new Integer(3), numOfMails);
    }

    @Test
    public void theOldestPerson() {

        List<Address> addresses = addresssBook.buildAddressBook();
        Address address = addresssBook.findOlderPerson();
        assertEquals("Wes",address.getFirstName());
        assertEquals("Jackson",address.getLastName());

    }

    @Test
    public void findPersonByFirstName() {

        List<Address> addresses = addresssBook.buildAddressBook();
        Address address = addresssBook.findPersonByFirstName("Bill");

        assertEquals("Bill",address.getFirstName());
        assertEquals("McKnight", address.getLastName());
    }

    @Test
    public void howManyDaysIsBillOlderThanPaul() {

        List<Address> addresses = addresssBook.buildAddressBook();
        Long daysOlder = addresssBook.howManyDaysOlder("Bill", "Paul");

        assertEquals(new Long(2862L),daysOlder);
    }
    @Test
    public void testReadAddress() {

        Address address = addresssBook.readAddress();
        DateTimeFormatter dtf =
                new DateTimeFormatterBuilder().appendPattern("dd/MM/")
                        .appendValueReduced(
                                ChronoField.YEAR, 2, 2, Year.now().getValue() - 80
                        ).toFormatter();
        String date1 = "16/03/77";

        LocalDate localDate = LocalDate.parse(date1,dtf);
        assertEquals("Bill",address.getFirstName());
        assertEquals("McKnight",address.getLastName());
        assertEquals("Male", address.getSex());
        assertEquals(localDate,address.getDob());
    }
}
