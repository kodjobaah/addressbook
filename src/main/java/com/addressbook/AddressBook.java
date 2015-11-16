package com.addressbook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kodjobaah on 16/11/2015.
 */
public class AddressBook {

    private final AddressBookFileReader addressBookFileReader;
    private ArrayList<Address> addresses;

    public AddressBook(String filename) throws FileNotFoundException {
         addressBookFileReader = new AddressBookFileReader(filename);
    }

    public List<Address> buildAddressBook() {

        addresses = new ArrayList<Address>();

        Address address = null;
        do {

            address = readAddress();
            if (address != null)
                addresses.add(address);

        } while(address != null);

        return addresses;

    }

    public Address readAddress() {

        DateTimeFormatter dtf =
                new DateTimeFormatterBuilder().appendPattern("dd/MM/")
                        .appendValueReduced(
                                ChronoField.YEAR, 2, 2, Year.now().getValue() - 80
                        ).toFormatter();
        Address address = null;
        String line = addressBookFileReader.readLine();


        if ((line != null) && (line.length() > 0)) {


            String[] vals = line.split(",");

            if (vals.length == 3) {

                String name = vals[0];
                String[] names = name.split(" ");

                String firstName = null;
                String lastName = null;
                if (names.length == 2) {

                    if (names[0] != null)
                        firstName = names[0].trim();

                    if (names[1] !=  null)
                        lastName = names[1].trim();
                }

                String sex = vals[1];

                if (sex != null) {
                    sex = sex.trim();
                }

                String dob = vals[2];

                LocalDate dobLocalDate = null;
                if (dob != null) {
                    dobLocalDate = LocalDate.parse(dob.trim(), dtf);

                }
                address = new Address(firstName,lastName,sex,dobLocalDate);
            }

        }

        return address;
    }

    public Integer getNumberOfMales() {

        Integer count = 0;
        for(Address address: addresses) {
            if ((address.getSex() != null) && (address.getSex().equals(Address.MALE))) {
                count = count + 1;
            }
        }
        return count;
    }


    public Address findOlderPerson() {

        Address oldestPerson = null;
        for(Address address: addresses) {

            if (oldestPerson == null) {

                oldestPerson = address;
            } else {

                if ((oldestPerson.getDob().isAfter(address.getDob()))) {
                    oldestPerson = address;
                }

            }

        }

        return oldestPerson;
    }
}
