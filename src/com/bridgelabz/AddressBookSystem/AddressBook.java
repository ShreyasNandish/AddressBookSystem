package com.bridgelabz.AddressBookSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook extends Contact {
    ArrayList<Contact> arrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    //Contact contact = new Contact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);

       public void addContact(){
            System.out.println("Enter the first name");
            String firstName = scanner.next().toLowerCase();
            System.out.println("Enter the last name");
            String lastName = scanner.next().toLowerCase();
            for (Contact contact : arrayList) {
                if ((contact.getFirstName().toLowerCase().equals(firstName)) && (contact.getLastName().toLowerCase().equals(lastName))) {
                    System.out.println("Contact already exist!!!");
                    return;
                }
            }
            Contact contact = new Contact();
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            System.out.print("Enter city: ");
            contact.setCity(scanner.next());
            System.out.print("Enter state: ");
            contact.setState(scanner.next());
            System.out.print("Enter address:  ");
            scanner.nextLine();
            contact.setAddress(scanner.nextLine());
            System.out.print("Enter Zipcode: ");
            contact.setZipCode(scanner.nextInt());
            System.out.print("Enter phone Number: ");
            contact.setPhoneNumber(scanner.nextInt());
            System.out.print("Enter email address: ");
            contact.setEmail(scanner.next());
            arrayList.add(contact);
        }


    public void ShowDetails() {
        System.out.println("First name is :" + firstName);
        System.out.println("Last name is :" + lastName);
        System.out.println("Address is :" + address);
        System.out.println("City is :" + city);
        System.out.println("State is :" + state);
        System.out.println("Zip code is :" + zipCode);
        System.out.println("Phone number is :" + phoneNumber);
        System.out.println("Email is :" + email);
    }

    public void editDetails() {
        if (arrayList.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Enter first name ");
            String firstName = scanner.next();
            boolean found = false;
            for (Contact contact : arrayList) {
                if (firstName.equals(contact.firstName)) {
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

    public void deleteContact() {
        System.out.println("Enter the first name of person to delete");
        String firstName = scanner.next();

        for (Contact contact : arrayList) {
            if (firstName.equals(contact.firstName)) {
                arrayList.remove(contact);
                break;
            } else {
                System.out.println("no contact found");
            }
        }
    }

    @Override
    public String toString()
    {
        return arrayList +"}\n";
    }
}
