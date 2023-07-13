package models;

import models.Contact;
import java.util.ArrayList;

public class PhoneBook{

	private ArrayList<Contact> contacts;

	public PhoneBook() {
		this.contacts = new ArrayList<Contact>();
	}

	// Create
	public void addContact(Contact newContact) {
		this.contacts.forEach((contact) -> {
			if (contact.getPhone().equals(newContact)){
				System.out.println("Um usuário com esse número já existe!");
				return;
			}
		});

		this.contacts.add(newContact);
	}

	// Read
	public ArrayList<Contact> getAllContacts(){return this.contacts;}

	public ArrayList<Contact> getContactsByName(String targetName) {
		ArrayList<Contact> searchResults = new ArrayList<Contact>();

		this.contacts.forEach((contact) -> {
			if (contact.getName().equals(targetName)) {
				searchResults.add(contact);
			}
		});

		return searchResults;
	}

	public Contact getContactByPhone(String phone) {
		//Contact result = null;
		return this.contacts.stream().filter(c -> c.getPhone().equals(phone)).findFirst().orElse(null);

		//this.contacts.forEach((contact) -> {
		//	if (contact.getPhone().equals(phone)) {
		//		return contact;
				//result = contact;
		//	}
		//});

		//return result;
	}

	// Update
	public void updateContacts(ArrayList<Contact> contacts) {this.contacts = contacts;}

	public void updateContactByPhone(String phone, Contact newContact) {
		this.contacts.forEach((contact) -> {
			if (contact.getPhone().equals(phone)) {
				contact = newContact;
			}
		});
	}

	// Delete
	public void deleteAllContacts() {this.contacts.clear();}

	public boolean deleteContactByPhone(String phone) {
		return this.contacts.removeIf(c -> c.getPhone().equals(phone));
	}


	// View
	public void show() {
		this.contacts.forEach((contact) -> {
			System.out.println(contact.toString());
		});
	}
}
