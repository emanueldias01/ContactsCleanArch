package br.com.emanueldias01.ContactsCleanArch.application.usecases;

import br.com.emanueldias01.ContactsCleanArch.application.gateways.ContactRepository;
import br.com.emanueldias01.ContactsCleanArch.domain.entities.Contact;

public class CreateContact {

    private final ContactRepository contactRepository;

    public CreateContact(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact createContact(Contact contact){
        return contactRepository.create(contact);
    }
}
