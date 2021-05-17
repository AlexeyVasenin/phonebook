package ru.vasenin.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vasenin.phonebook.domain.Contacts;
import ru.vasenin.phonebook.services.ContactsServiceImpl;

import java.util.List;

@RestController
public class ContactsController {
    private final ContactsServiceImpl contactsService;

    @Autowired
    public ContactsController(ContactsServiceImpl contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping(value = "/contacts", produces = "application/json")
    public List<Contacts> listAll() {
        return contactsService.listAllContacts();
    }


}
