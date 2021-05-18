package ru.vasenin.phonebook.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vasenin.phonebook.domain.Contacts;
import ru.vasenin.phonebook.services.ContactsServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    private final ContactsServiceImpl contactsService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ContactsController(ContactsServiceImpl contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping(value = "/list")
    public List<Contacts> listAll() throws JsonProcessingException {
        objectMapper.writeValueAsString(contactsService.listAllContacts());
        return contactsService.listAllContacts();
    }

    @PutMapping("/update")
    public ResponseEntity<Contacts> update(@RequestParam("id") Long id,
                                           @RequestParam("email") String email,
                                           @RequestParam("number_tel") Integer number,
                                           @RequestParam("address") String address,
                                           @RequestParam("skype") String skype) {
        Contacts contacts = new Contacts(id, email, number, address, skype);
        return contactsService.update(contacts);
    }

    @PostMapping("/add")
    public void create(@RequestParam("id") Long id,
                                           @RequestParam("email") String email,
                                           @RequestParam("number_tel") Integer number,
                                           @RequestParam("address") String address,
                                           @RequestParam("skype") String skype,
                                           @RequestParam("persona_id") Long personaId) {
        Contacts contacts = new Contacts(id, email, number, address, skype,
                personaId);
        contactsService.add(contacts);
    }
}
