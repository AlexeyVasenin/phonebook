package ru.vasenin.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vasenin.phonebook.domain.Persona;
import ru.vasenin.phonebook.services.PersonaService;

import java.util.List;

@Controller
public class PersonaControllers {

    private final PersonaService personaService;

    @Autowired
    public PersonaControllers(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> readAll() {
        List<Persona> personas = personaService.readAll();
        return personas != null && !personas.isEmpty()
                ? new ResponseEntity<>(personas, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
