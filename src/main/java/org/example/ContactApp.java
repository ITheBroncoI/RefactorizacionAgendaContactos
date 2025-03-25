package org.example;

import java.util.*;

public class ContactApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactService service = new ContactService();
    private static boolean running = true;  // Bandera de control para el ciclo

    public static void main(String[] args) {
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer
            handleUserChoice(choice);
        }
    }


    // Imprimir el menú
    private static void printMenu() {
        System.out.println("""
                1.Añadir\s
                2.Mostrar\s
                3.Buscar\s
                4.Borrar\s
                5.Salir\s
                """);
    }

    // Manejar elección del usuario
    private static void handleUserChoice(int choice) {
        switch (choice) {
            case 1 -> addContact();
            case 2 -> service.printContacts();
            case 3 -> findContact();
            case 4 -> deleteContact();
            case 5 -> exitProgram(); // Cambiar el control de salida
            default -> System.out.println("Opcion no valida");
        }
    }

    private static void exitProgram() {
        System.out.println("Exiting program...");
        running = false; // Cambiar el estado de la bandera de control
    }


    // Agregar contacto
    private static void addContact() {
        System.out.println("Digite el nombre:");
        String name = scanner.nextLine();
        System.out.println("Digite el número de telefono:");
        String phone = scanner.nextLine();
        service.addContact(new Contact(name, phone));
    }

    // Buscar contacto
    private static void findContact() {
        System.out.println("Digite el nombre:");
        String search = scanner.nextLine();
        service.findContact(search).ifPresentOrElse(
                contact -> System.out.println("Contacto encontrado: " + contact.getName() + " " + contact.getPhone()),
                () -> System.out.println("No encontrado")
        );
    }

    // Eliminar contacto
    private static void deleteContact() {
        System.out.println("Digite el nombre:");
        String name = scanner.nextLine();
        service.deleteContact(name);
        System.out.println("Contacto eliminado");
    }
}