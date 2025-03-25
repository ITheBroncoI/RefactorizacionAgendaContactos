package org.example;

import java.util.*;

class ContactService {
    static List<Contact> contacts = new ArrayList<>();

    void addContact(Contact c) {
        contacts.add(c);
    }

    Contact findContact(String name) {
        for (Contact c : contacts) if (c.name.equals(name)) return c;
        return null;
    }

    void deleteContact(String name) {
        for (int i = 0; i < contacts.size(); i++) if (contacts.get(i).name.equals(name)) contacts.remove(i);
    }

    void printContacts() {
        if (contacts.size() == 0) System.out.println("No contacts.");
        else for (Contact c : contacts) System.out.println("Name: " + c.name + ", Phone: " + c.phone);
    }
}
