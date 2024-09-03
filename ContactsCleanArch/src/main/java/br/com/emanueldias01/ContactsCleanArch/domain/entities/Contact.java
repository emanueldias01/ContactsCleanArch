package br.com.emanueldias01.ContactsCleanArch.domain.entities;

public class Contact {

    private String name;
    private Long phone;

    public Contact(){

    }

    public Contact(String name, Long phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() < 3){
            throw new RuntimeException("O nome de um contato deve ter no mínimo 3 caracteres");
        }else {
            this.name = name;
        }
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        if(phone.toString().length() < 8){
            throw new RuntimeException("O numero de um contato deve ter no mínimo 8 numeros");
        }else {
            this.phone = phone;
        }
    }
}
