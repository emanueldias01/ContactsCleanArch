package br.com.emanueldias01.ContactsCleanArch.infra.controller;

import br.com.emanueldias01.ContactsCleanArch.application.usecases.CreateContact;
import br.com.emanueldias01.ContactsCleanArch.application.usecases.ListContacts;
import br.com.emanueldias01.ContactsCleanArch.domain.entities.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final CreateContact createContact;
    private final ListContacts listContacts;

    public ContactController(CreateContact createContact, ListContacts listContacts) {
        this.createContact = createContact;
        this.listContacts = listContacts;
    }

    @GetMapping
    public List<Contact> getAllContacts(){
        return listContacts.listAllContacts();
    }

    @PostMapping
    public Contact newContact(@RequestBody Contact contact){
        return createContact.createContact(contact);
    }
}
