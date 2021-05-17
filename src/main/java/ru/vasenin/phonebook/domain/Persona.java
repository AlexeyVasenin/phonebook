package ru.vasenin.phonebook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "firstname")
    private String firstName;//Имя

    @Column(name = "lastname")
    private String lastName;//Фамилия

    @Column(name = "middlename")
    private String middleName;//отчество

    @Column(name = "dateofbirth")
    private String dateOfBirth;//дата рождения

    @Column(name = "email")
    private String email;

    @Column(name = "number")
    private int number;

    @Column(name = "address")
    private String address;

    @Column(name = "skype")
    private String skype;

    public Persona(String firstname, String lastname, String middlename) {
    }

    public Persona(String date) {
    }

    public Persona() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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
}


