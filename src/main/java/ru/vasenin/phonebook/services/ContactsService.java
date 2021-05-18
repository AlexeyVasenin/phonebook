package ru.vasenin.phonebook.services;

import org.springframework.http.ResponseEntity;
import ru.vasenin.phonebook.domain.Contacts;

import java.util.List;

public interface ContactsService {

    List<Contacts> listAllContacts();

    void add(Contacts contacts);

    ResponseEntity<Contacts> update(Contacts contacts);
}
