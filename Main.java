package in.sid;

import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone= new MobilePhone("7829055245");

    public static void main(String[] args) {
	    boolean quit = false;
        System.out.println("Starting Phone...");
	    printActions();
	    while (!quit){
            System.out.println("Enter required Action");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Shutting down...");
                    quit=true;
                    break;
                case 1:
                    printContacts();
                    clearScreen();
                    break;
                case 2:
                    addContact();
                    clearScreen();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void printActions(){
        System.out.println("Available actions:\nPress..");
        System.out.println("\t0- Shutdown\n" +
                "\t1- Print Contacts\n" +
                "\t2- Add new Contact\n" +
                "\t3- Update existing Contact\n" +
                "\t4- Delete a Contact\n" +
                "\t5- Query if a contact exists\n" +
                "\t6- Print list of Actions");

    }

    private static void printContacts(){
       mobilePhone.printContact();
    }

    private static void addContact(){
        System.out.println("Enter new contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = Contact.createNewContact(name,phoneNumber);
        if(mobilePhone.addNewContact(contact)){
            System.out.println("New contact added");
        }else
            System.out.println("Cant Add contact");
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createNewContact(newName,newNumber);
        if(mobilePhone.updateContact(existingContact,newContact))
            System.out.println("Successfully updated new contact");
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        if(mobilePhone.removeContact(existingContact)){
            System.out.println("Successfully deleted the contact");
        }
        else
            System.out.println("Contact not found");
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existingContact.getName() + "Phone number " + existingContact.getPhoneNumber());
    }

    private static void clearScreen()  {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
