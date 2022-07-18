package com.bridgelabz.AddressBookSystem;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program ");
        Contact contact=new Contact();
        contact.setContactDetails();

        AddressBook addressBook1=new AddressBook();
        addressBook1.add(contact);
        addressBook1.print();

        System.out.println("*************************");

        Contact contact1=new Contact();
        contact1.setContactDetails();
        AddressBook addressBook2=new AddressBook();
        addressBook2.add(contact1);
        addressBook2.print();
    }
}
