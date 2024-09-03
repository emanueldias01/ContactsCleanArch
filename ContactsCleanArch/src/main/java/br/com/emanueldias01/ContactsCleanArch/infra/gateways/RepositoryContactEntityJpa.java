package br.com.emanueldias01.ContactsCleanArch.infra.gateways;

import br.com.emanueldias01.ContactsCleanArch.application.gateways.ContactRepository;
import br.com.emanueldias01.ContactsCleanArch.domain.entities.Contact;
import br.com.emanueldias01.ContactsCleanArch.infra.persistence.ContactEntity;
import br.com.emanueldias01.ContactsCleanArch.infra.persistence.ContactEntityRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositoryContactEntityJpa implements ContactRepository {
    private final ContactEntityRepository contactEntityRepository;

    public RepositoryContactEntityJpa(ContactEntityRepository contactEntityRepository) {
        this.contactEntityRepository = contactEntityRepository;
    }


    @Override
    public Contact create(Contact contact) {
        ContactEntity entity = contactEntityRepository.save(new ContactEntity(contact.getName(), contact.getPhone()));
        return new Contact(entity.getName(), entity.getPhone());
    }

    @Override
    public List<Contact> listAll() {
        return contactEntityRepository.findAll().stream().map(u -> new Contact(u.getName(), u.getPhone())).collect(Collectors.toList());
    }
}
