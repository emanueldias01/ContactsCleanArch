package br.com.emanueldias01.ContactsCleanArch.infra.gateways;

import br.com.emanueldias01.ContactsCleanArch.application.gateways.ContactRepository;
import br.com.emanueldias01.ContactsCleanArch.domain.entities.Contact;
import br.com.emanueldias01.ContactsCleanArch.domain.entities.ContactFactory;
import br.com.emanueldias01.ContactsCleanArch.infra.persistence.ContactEntity;
import br.com.emanueldias01.ContactsCleanArch.infra.persistence.ContactEntityRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositoryContactEntityJpa implements ContactRepository {
    private final ContactEntityRepository contactEntityRepository;

    private final ContactFactory factory;

    public RepositoryContactEntityJpa(ContactEntityRepository contactEntityRepository, ContactFactory factory) {
        this.contactEntityRepository = contactEntityRepository;
        this.factory = factory;
    }


    @Override
    public Contact create(Contact contact) {
        ContactEntity entity = contactEntityRepository.save(new ContactEntity(contact.getName(), contact.getPhone()));
        return new Contact(entity.getName(), entity.getPhone());
    }

    @Override
    public List<Contact> listAll() {
        return contactEntityRepository.findAll().stream().map(u -> factory.createContact(u.getName(), u.getPhone())).collect(Collectors.toList());
    }
}
