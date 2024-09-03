package br.com.emanueldias01.ContactsCleanArch.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactEntityRepository extends JpaRepository<ContactEntity, Long> {
}
