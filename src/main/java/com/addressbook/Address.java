package com.addressbook;

import java.time.LocalDate;

/**
 * Created by kodjobaah on 16/11/2015.
 */
public class Address {

    public static String MALE = "Male";
    private final String firstName;
    private final String lastName;
    private final String sex;
    private final LocalDate dob;


    public Address(String firstName, String lastName, String sex, LocalDate dob) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Address{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", dob=" + dob +
                '}';
    }
}
