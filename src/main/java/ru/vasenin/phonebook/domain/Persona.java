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

    public Persona(String firstName, String lastName, String middleName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
    }

    public Persona() {

    }

    public Persona(long id, String firstName, String lastName, String middleName, String dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
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

}


