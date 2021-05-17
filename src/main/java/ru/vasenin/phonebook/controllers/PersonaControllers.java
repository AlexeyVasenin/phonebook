package ru.vasenin.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vasenin.phonebook.domain.Persona;
import ru.vasenin.phonebook.services.PersonaService;

import java.time.Period;
import java.util.List;

@RestController
public class PersonaControllers {

    private final PersonaService personaService;

    @Autowired
    public PersonaControllers(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping(value = "/personas", produces = "application/json")
    public List<Persona> listAll() {
        return personaService.listAllPersona();
    }

    @PostMapping("/persona/add")
    public void create(@RequestParam("firstname") String firstName,
                       @RequestParam("lastname") String lastName,
                       @RequestParam("middlename") String middleName,
                       @RequestParam("dateofBirth") String dateOfBirth) {
        Persona persona = new Persona(firstName, lastName, middleName,
                dateOfBirth);
        personaService.save(persona);
    }

    @PutMapping("/update")
    public void update(@RequestParam("id") Long id,
                       @RequestParam("firstname") String firstName,
                       @RequestParam("lastname") String lastName,
                       @RequestParam("middlename") String middleName,
                       @RequestParam("dateofBirth") String dateOfBirth) {
        Persona persona = new Persona(id, firstName, lastName, middleName,
                dateOfBirth);
        personaService.update(persona);

    }


}
