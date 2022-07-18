package com.bridgelabz.AddressBookSystem;

public class AddressBook {
    Contact[] con=new Contact[100];
    int index=0;
    public void add(Contact contact)
    {
        con[index]=contact;
        index++;
    }

    public void print()
    {
        for (int i = 0; i < index; i++) {
            con[i].viewContactData();
        }
    }
}
