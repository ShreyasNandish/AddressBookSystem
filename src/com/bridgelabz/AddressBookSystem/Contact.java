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

    public Contact()
    {

    }

    public Contact(String firstName, String lastName, String address, String city, String state, double zipCode, long phoneNumber, String email)
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

    @Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zipCode +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                "}\n";
    }
}



