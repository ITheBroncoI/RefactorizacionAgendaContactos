package org.example;

import java.util.*;

class ContactService {
    private final List<Contact> contacts = new ArrayList<>(); // No es estático, se maneja por instancia

    // Agregar contacto
    public void addContact(Contact c) {
        contacts.add(c);
    }

    // Buscar contacto
    public Optional<Contact> findContact(String name) {
        return contacts.stream().filter(c -> c.getName().equals(name)).findFirst();
    }

    // Eliminar contacto
    public void deleteContact(String name) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.getName().equals(name)) {
                iterator.remove();
                break; // Se de tiene el bucle al momento de encontrar el contacto
            }
        }
    }

    // Mostrar contactos
    public void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No existen contacos guardados");
        } else {
            contacts.forEach(c -> System.out.println("Nombre: " + c.getName() + ", Telefono: " + c.getPhone()));
        }
    }
}
