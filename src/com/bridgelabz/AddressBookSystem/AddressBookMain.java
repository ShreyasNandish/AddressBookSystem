package com.bridgelabz.AddressBookSystem;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        AddressBook addressBook = new AddressBook();

        Scanner scanner = new Scanner(System.in);

        boolean exit = true;
        while (exit) {
            System.out.println("Select option: \n" +
                    "1.Add Contact \n" +
                    "2.Edit Contact \n" +
                    "3.Show Contact \n"+
                    "4.Delete \n" +
                    "5.Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addressBook.contactDetails();
                    break;
                case 2:
                    addressBook.editDetails();
                    break;
                case 3:
                    addressBook.ShowDetails();
                    break;
                case 4:
                    addressBook.deleteContact();
                    break;
                case 5:
                    exit = false;
                default:
                    break;
            }
        }
    }
    }

