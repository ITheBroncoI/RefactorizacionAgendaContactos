package org.example;

import java.util.*;

public class ContactApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactService service = new ContactService();
        while (true) {
            System.out.println("1.Añadir \n" +
                    "2.Mostrar \n" +
                    "3.Buscar \n" +
                    "4.Borrar \n" +
                    "5.Salir \n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Ingresa el nombre:");
                String name = scanner.nextLine();
                System.out.println("Ingresa el numero:");
                String phone = scanner.nextLine();
                service.addContact(new Contact(name, phone));
            } else if (choice == 2) service.printContacts();
            else if (choice == 3) {
                System.out.println("Enter name:");
                String search = scanner.nextLine();
                Contact found = service.findContact(search);
                if (found != null) System.out.println("Contacto encontrado: " + found.name + " " + found.phone);
                else System.out.println("Sin resultado.");
            } else if (choice == 4) {
                System.out.println("Ingresa el nombre:");
                String del = scanner.nextLine();
                service.deleteContact(del);
                System.out.println("Contacto eliminado");
            } else if (choice == 5) break;
            else System.out.println("Opcion invalida");
        }
    }
}