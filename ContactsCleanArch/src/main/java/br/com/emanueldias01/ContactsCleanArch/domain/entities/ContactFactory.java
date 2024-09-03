package br.com.emanueldias01.ContactsCleanArch.domain.entities;

public class ContactFactory {

    private Contact contact;

    public Contact createContact(String name, Long phone){
        this.contact = new Contact();
        this.contact.setName(name);
        this.contact.setPhone(phone);
        return this.contact;
    }
}
