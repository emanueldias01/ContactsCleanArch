package br.com.emanueldias01.ContactsCleanArch.application.gateways;

import br.com.emanueldias01.ContactsCleanArch.domain.entities.Contact;

import java.util.List;

public interface ContactRepository {

    Contact create(Contact contact);

    List<Contact> listAll();
}
