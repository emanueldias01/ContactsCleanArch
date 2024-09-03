package br.com.emanueldias01.ContactsCleanArch.application.usecases;

import br.com.emanueldias01.ContactsCleanArch.application.gateways.ContactRepository;
import br.com.emanueldias01.ContactsCleanArch.domain.entities.Contact;

import java.util.List;

public class ListContacts {

    private final ContactRepository contactRepository;

    public ListContacts(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> listAllContacts(){
        return contactRepository.listAll();
    }
}
