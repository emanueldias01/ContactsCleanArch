package br.com.emanueldias01.ContactsCleanArch.domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void createContactSucess(){
        ContactFactory factory = new ContactFactory();
        Contact contact = factory.createContact("username", 12345678l);

        Assertions.assertEquals("username", contact.getName());
    }

    @Test
    void dontCreateContactBeacuseNameIsShort(){
        ContactFactory factory = new ContactFactory();
        Assertions.assertThrows(RuntimeException.class, () -> factory.createContact("ab", 12345678l));
    }

    @Test
    void dontCreateContactBeacusePhoneIsShort(){
        ContactFactory factory = new ContactFactory();
        Assertions.assertThrows(RuntimeException.class, () -> factory.createContact("123", 1234567l));
    }

}