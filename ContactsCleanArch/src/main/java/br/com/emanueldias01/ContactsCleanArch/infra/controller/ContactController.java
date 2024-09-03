package br.com.emanueldias01.ContactsCleanArch.infra.controller;

import br.com.emanueldias01.ContactsCleanArch.application.usecases.CreateContact;
import br.com.emanueldias01.ContactsCleanArch.application.usecases.ListContacts;
import br.com.emanueldias01.ContactsCleanArch.domain.entities.Contact;
import br.com.emanueldias01.ContactsCleanArch.domain.entities.ContactFactory;
import br.com.emanueldias01.ContactsCleanArch.infra.controller.dto.ContactDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<ContactDto> getAllContacts(){
        return listContacts.listAllContacts().stream().map(c -> new ContactDto(c.getName(), c.getPhone())).collect(Collectors.toList());
    }

    @PostMapping
    public Contact newContact(@RequestBody ContactDto dto){
        ContactFactory factory = new ContactFactory();
        Contact contact = factory.createContact(dto.name(), dto.phone());
        return createContact.createContact(contact);
    }
}
