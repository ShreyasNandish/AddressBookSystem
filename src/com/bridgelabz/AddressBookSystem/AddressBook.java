package com.bridgelabz.AddressBookSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook extends Contact{
    ArrayList<Contact> arrayList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Contact contact = new Contact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);

    public void contactDetails()
    {
        System.out.println("Enter First Name:-");
        firstName = scanner.next();
        System.out.println("Enter Last Name:-");
        lastName = scanner.next();
        System.out.println("Enter Address:-");
        address = scanner.next();
        System.out.println("Enter the city");
        city = scanner.next();
        System.out.println("Enter the state:-");
        state = scanner.next();
        System.out.println("Enter the zip code :-");
        zipCode = scanner.nextDouble();
        System.out.println("Enter Phone number :-");
        phoneNumber = scanner.nextLong();
        System.out.println("Enter email :-");
        email = scanner.next();

        arrayList.add(new Contact(firstName, lastName, address, city, state, zipCode, phoneNumber, email));
        System.out.println("Added successfully");
    }

    public void ShowDetails()
    {
        System.out.println("First name is :"+firstName);
        System.out.println("Last name is :"+lastName);
        System.out.println("Address is :"+address);
        System.out.println("City is :"+city);
        System.out.println("State is :"+state);
        System.out.println("Zip code is :"+zipCode);
        System.out.println("Phone number is :"+phoneNumber);
        System.out.println("Email is :"+email);
    }

    public void editDetails()
    {
        if(arrayList.isEmpty())
        {
            System.out.println("Empty");
        }
        else {
            System.out.println("Enter first name ");
            String firstName = scanner.next();
            boolean found = false;
            for(Contact contact :arrayList)
            {
                if(firstName.equals(contact.firstName))
                {
                    System.out.println("Enter First Name:");
                    contact.firstName = scanner.next();
                    System.out.println("Enter Last Name:");
                    contact.lastName = scanner.next();
                    System.out.println("Enter Address:");
                    contact.address = scanner.next();
                    System.out.println("Enter the city");
                    contact.city = scanner.next();
                    System.out.println("Enter the state:");
                    contact.state = scanner.next();
                    System.out.println("Enter the zip code :");
                    contact.zipCode = scanner.nextDouble();
                    System.out.println("Enter Phone number :");
                    contact.phoneNumber = scanner.nextLong();
                    System.out.println("Enter email :");
                    contact.email = scanner.next();
                }
            }
        }
    }

}
