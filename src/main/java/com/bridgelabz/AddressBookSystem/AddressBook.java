package com.bridgelabz.AddressBookSystem;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook extends Contact {
    ArrayList<Contact> list = new ArrayList<>();

    Map<Contact,String> cityDictionary  = new HashMap<>();
    Map<Contact,String> stateDictionary  = new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    void addContact() throws IOException {
        System.out.println("Enter the first name");
        String firstName = scanner.next().toLowerCase();
        System.out.println("Enter the last name");
        String lastName = scanner.next().toLowerCase();
        if (list.stream().anyMatch(x -> x.getFirstName().toLowerCase().equals(firstName) && x.getLastName().toLowerCase().equals(lastName))) {
            System.out.println("Contact already exist!!!");
            return;
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
        contact.setZipCode(scanner.nextLine());
        System.out.print("Enter phone Number: ");
        contact.setPhoneNumber(scanner.nextLine());
        System.out.print("Enter email address: ");
        contact.setEmail(scanner.next());
        list.sort(Comparator.comparing(Contact::getFirstName));
        list.add(contact);
    }

    void writeAddressBook(ArrayList<Contact> arrayList,String addressBookName) throws IOException {
        System.out.println("Enter\n 1) To write to txt file\n 2) To write to CSV file");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                FileReadWrite.writeTxt(arrayList, addressBookName);
                break;
            case 2:
                FileReadWrite.writeCSV(arrayList, addressBookName);
                break;
        }
    }

    void readAddressBook(String addressBookName) throws IOException {
        System.out.println("Select option \n1.read from text file \n2.read from csv file");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                FileReadWrite.readTxtFile(new File(FileReadWrite.PATH.concat(addressBookName+".txt")));
                break;
            case 2:
                FileReadWrite.readCSVFile(new File(FileReadWrite.PATH.concat( addressBookName +".csv")));
                break;
        }
    }

    void editContact(){
        if(list.isEmpty()){
            System.out.println("Address book is empty");
        }
        else {
            System.out.println("Enter the first name of person to edit");
            String firstName = scanner.next().toLowerCase();
            System.out.println("Enter the last name of person to edit");
            String lastName = scanner.next().toLowerCase();

            boolean found = false;
            for (Contact contact : list) {
                if (firstName.equals(contact.getFirstName().toLowerCase())) {
                    if (lastName.equals(contact.getLastName())) {
                        System.out.println("Edit the details of person");
                        System.out.print("Enter first name: ");
                        contact.setFirstName(scanner.next());

                        System.out.print("Enter last Name: ");
                        contact.setLastName(scanner.next());

                        System.out.print("Enter Email: ");
                        contact.setEmail(scanner.next());

                        System.out.print("Enter address: ");
                        scanner.nextLine();
                        contact.setAddress(scanner.nextLine());

                        System.out.print("Enter phone number: ");
                        contact.setPhoneNumber(scanner.nextLine());

                        System.out.print("Enter state: ");
                        contact.setState(scanner.next());

                        System.out.print("Enter city: ");
                        contact.setCity(scanner.next());

                        System.out.print("Enter zip: ");
                        contact.setZipCode(scanner.nextLine());
                        found = true;
                        break;
                    }

                }
            }
            if (!found) {
                System.out.println("No contact found");
            }
        }
    }

    void searchContact() throws IOException{
        if(list.isEmpty()){
            System.out.println("No contacts to search in the addressBook");
            return;
        }
        list.sort(Comparator.comparing(Contact::getFirstName));
        list.forEach(System.out::println);
    }

    void deleteContact(){
        if(list.isEmpty()){
            System.out.println("Address book is empty");
        }
        else {
            System.out.println("Enter the first name of person to delete");
            String firstName = scanner.next().toLowerCase();
            System.out.println("Enter the last name of person to delete");
            String lastName = scanner.next().toLowerCase();
            boolean found = false;
            for (Contact contact :list){
                if (firstName.equals(contact.getFirstName().toLowerCase())) {
                    if (lastName.equals(contact.getLastName())) {
                        list.remove(contact);
                        found = true;
                        System.out.println("Contact deleted successfully");
                        break;
                    }
                }
            }
            if (!found){
                System.out.println("No contact found");
            }
        }
    }

//    void writeData() throws IOException {
//        FileIOService fileIOService = new FileIOService();
//        fileIOService.writeData();
//    }

//    void readData() throws IOException {
//        FileIOService fileIOService = new FileIOService();
//        fileIOService.readData();
//    }


    void displayContacts(){
        if(list.isEmpty()){
            System.out.println("No contacts to display");
            return;
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("""
                    Enter option
                    1) To view by City
                    2) To view by State
                    3) To exit
                    """);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the city name to view");
                    String city = scanner.next().toLowerCase();
                    Map<String,List<Contact>> cityDictionary  = new HashMap<>();
                    for (AddressBook addressBooks : AddressBookMain.map.values()) {
                        List<Contact> contactsCityList = addressBooks.list.stream().filter(x -> x.getCity().toLowerCase().equals(city)).collect(Collectors.toList());
                        if(cityDictionary.containsKey(city)){
                            cityDictionary.get(city).addAll(contactsCityList);
                        }
                        else
                            cityDictionary.put(city,contactsCityList);
                    }

                    System.out.println("No of contacts in city "+city+" are "+cityDictionary.size());
                    System.out.println("Contacts in city "+city+" are:");
                    cityDictionary.values().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Enter the state name to view");
                    String state = scanner.next().toLowerCase();
                    Map<String,List<Contact>> stateDictionary  = new HashMap<>();
                    for (AddressBook addressBooks : AddressBookMain.map.values()) {
                        List<Contact> contactsStateList = addressBooks.list.stream().filter(x -> x.getState().toLowerCase().equals(state)).collect(Collectors.toList());
                        if (stateDictionary.containsKey(state)) {

                            stateDictionary.get(state).addAll(contactsStateList);
                        }
                        else
                            stateDictionary.put(state,contactsStateList);
                    }

                    System.out.println("No of contacts in state "+state+" are "+stateDictionary.size());
                    System.out.println("Contacts in state "+state+" are:");
                    System.out.println(stateDictionary.values());
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void sortByState()
    {
        if (list.isEmpty())
        {
            System.out.println("No contacts found");
            return;
        }
        list.sort(Comparator.comparing(Contact::getState));
        list.forEach(System.out::println);
    }

    public void sortByCity()
    {
        if (list.isEmpty())
        {
            System.out.println("No contacts found");
            return;
        }
        list.sort(Comparator.comparing(Contact::getCity));
        list.forEach(System.out::println);
    }

    public void sortByZipCode()
    {
        if (list.isEmpty())
        {
            System.out.println("No contacts found");
            return;
        }
        list.sort(Comparator.comparing(Contact::getZipCode));
        list.forEach(System.out::println);
    }
    @Override
    public String toString() {
        return  list +
                "}\n";
    }
}
