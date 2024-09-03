package br.com.emanueldias01.ContactsCleanArch.infra.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long phone;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
