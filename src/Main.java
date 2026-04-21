package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        contacts = JsonHandler.loadContacts();
        System.out.println("=== ContactBook CLI ===");
        System.out.println("Loaded " + contacts.size() + " contacts.");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput("Choose option: ");

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    listContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    running = false;
                    JsonHandler.saveContacts(contacts);
                    System.out.println("Contacts saved. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try 1-5.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts");
        System.out.println("3. Search Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Exit & Save");
    }

    private static void addContact() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added!");
    }

    private static void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts yet.");
            return;
        }
        System.out.println("\n--- All Contacts ---");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String query = scanner.nextLine().toLowerCase();
        boolean found = false;
        
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(query)) {
                System.out.println("Found: " + c);
                found = true;
            }
        }
        if (!found) System.out.println("No contacts found.");
    }

    private static void deleteContact() {
        listContacts();
        if (contacts.isEmpty()) return;
        
        int index = getIntInput("Enter number to delete: ") - 1;
        if (index >= 0 && index < contacts.size()) {
            Contact removed = contacts.remove(index);
            System.out.println("Deleted: " + removed.getName());
        } else {
            System.out.println("Invalid number.");
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}