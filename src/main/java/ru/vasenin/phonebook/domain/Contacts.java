package ru.vasenin.phonebook.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contacts {

    @Id
    @Column(name = "id")
    @JsonProperty
    private Long id;

    @Column(name = "email")
    @JsonProperty
    private String email;

    @Column(name = "number_tel")
    @JsonProperty
    private Integer number;

    @Column(name = "address")
    @JsonProperty
    private String address;

    @Column(name = "skype")
    @JsonProperty
    private String skype;

    @Column(name = "persona_id")
    @JsonProperty
    private Long personaId;

    public Contacts(Long id, String email, Integer number, String address, String skype) {
        this.id = id;
        this.email = email;
        this.number = number;
        this.address = address;
        this.skype = skype;
    }

    public Contacts(Long id, String email, Integer number, String address, String skype, Long personaId) {
        this.id = id;
        this.email = email;
        this.number = number;
        this.address = address;
        this.skype = skype;
        this.personaId = personaId;
    }

    public Contacts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

}
