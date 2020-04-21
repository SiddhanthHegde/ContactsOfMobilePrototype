package in.sid;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName())>=0){
            System.out.println("Contact already exists in File");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String name){
        for(int i = 0;i< this.myContacts.size();i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " Not found :(");
            return false;
        }
        myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    public String queryContact(Contact contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position>=0)
            return this.myContacts.get(position);
        return null;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName() + " not found :(");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted");
        return true;
    }

    public void printContact(){
        if(myContacts.size()==0){
            System.out.println("No contacts found");
        }
        else {
            System.out.println("Contact List:");
            for(int i = 0; i < myContacts.size() ; i++){
                System.out.println((i+1) + "." + this.myContacts.get(i).getName()+ "->" + this.myContacts.get(i).getPhoneNumber());
            }
        }
    }

}
