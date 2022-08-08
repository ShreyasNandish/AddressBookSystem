package com.bridgelabz.AddressBookSystem;

import java.util.Scanner;
public class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    double zipCode;
    long phoneNumber;
    String email;

    Contact()
    {

    }

    Contact(String firstName, String lastName, String address, String city, String state, double zipCode, long phoneNumber, String email)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
}



