package br.com.emanueldias01.ContactsCleanArch.infra.config;

import br.com.emanueldias01.ContactsCleanArch.application.gateways.ContactRepository;
import br.com.emanueldias01.ContactsCleanArch.application.usecases.CreateContact;
import br.com.emanueldias01.ContactsCleanArch.application.usecases.ListContacts;
import br.com.emanueldias01.ContactsCleanArch.domain.entities.ContactFactory;
import br.com.emanueldias01.ContactsCleanArch.infra.gateways.RepositoryContactEntityJpa;
import br.com.emanueldias01.ContactsCleanArch.infra.persistence.ContactEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    CreateContact createContact(ContactRepository repository){
        return new CreateContact(repository);
    }

    @Bean
    ListContacts listContacts(ContactRepository repository){
        return new ListContacts(repository);
    }

    @Bean
    RepositoryContactEntityJpa repositoryContactEntityJpa(ContactEntityRepository repository, ContactFactory factory){
        return new RepositoryContactEntityJpa(repository, factory);
    }

    @Bean
    ContactFactory contactFactory(){
        return new ContactFactory();
    }
}
