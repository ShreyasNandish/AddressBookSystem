package com.bridgelabz.AddressBookSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    static Scanner scanner = new Scanner(System.in);
    static AddressBook addressBook;
    static HashMap<String, AddressBook> map = new HashMap<>();
    public static ArrayList<String> addressBooks = new ArrayList<>();
    static String currentAddressBook;
    static String addressBookName;

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    \nEnter options:
                    1) add contact
                    2) edit Contact
                    3) display Contacts
                    4) delete contact
                    5) add address book or select addressBook
                    6) search contact
                    7) exit""");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    try {
                        map.get(currentAddressBook).addContact();
                    } catch (Exception e) {
                        System.out.println("\nNo AddressBook Found\n");
                    }

                    break;
                case 2:
                    try {
                        map.get(currentAddressBook).editContact();
                    } catch (Exception e) {
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 3:
                    try {
                        addressBook.displayContacts();
                    } catch (Exception e) {
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 4:
                    try {
                        map.get(currentAddressBook).deleteContact();
                    } catch (Exception e) {
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 5:
                    chooseAddressBook();
                    break;
                case 6:
                    try {
                        addressBook.searchContact();
                    } catch (Exception e) {
                        System.out.println("\nNo AddressBook Found\n");
                    }
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
        System.out.println(map);
    }

    static void chooseAddressBook() {
        System.out.println("""
        Press 1 to add AddressBook
        Press 2 to select AddressBook""");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter address book name");
                addressBookName = scanner.next().toLowerCase();
                if (map.containsKey(addressBookName)) {
                    System.out.println("\nAddress book already exist\n");
                    chooseAddressBook();
                } else {
                    addressBook = new AddressBook();
                    map.put(addressBookName, addressBook);
                    currentAddressBook = addressBookName;
                }
                addressBooks.add(addressBookName);

                break;
            case 2:
                System.out.println("Enter address book name");
                addressBookName = scanner.next().toLowerCase();
                if (!map.containsKey(addressBookName)) {
                    System.out.println("\nAddressBook not Found\n");
                    chooseAddressBook();
                } else
                    currentAddressBook = addressBookName;
                break;
            default:
                break;
        }
    }
    }

