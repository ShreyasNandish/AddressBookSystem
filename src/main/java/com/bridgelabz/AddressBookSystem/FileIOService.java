package com.bridgelabz.AddressBookSystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOService {
    private final String FILE_PATH ="A:\\AddressBookSystem\\src\\com\\bridgelabz\\AddressBookSystem\\contact.txt";

            public boolean writeData() throws IOException
            {
                int i=0;
                StringBuffer stringBuffer = new StringBuffer();
                for (AddressBook addressBook : AddressBookMain.map.values())
                {
                    String addressBookName = AddressBookMain.addressBooks.get(i++);
                    stringBuffer.append(addressBookName);
                    addressBook.list.forEach(empData -> {
                        String empDataString = empData.toString().concat("\n");
                        stringBuffer.append(empDataString);
                    });
                }
                Path path = Files.write(Paths.get(FILE_PATH),stringBuffer.toString().getBytes());
                return path != null ? true : false;
            }
    public void readData() throws IOException {
        Files.lines(new File(FILE_PATH).toPath()).forEach(System.out::println);
    }
}
