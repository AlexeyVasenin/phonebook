package ru.vasenin.phonebook.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vasenin.phonebook.domain.Persona;
import ru.vasenin.phonebook.services.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaControllers {

    private final PersonaService personaService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public PersonaControllers(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping(value = "/list")
    public List<Persona> listAll() throws JsonProcessingException {
        objectMapper.writeValueAsString(personaService.listAllPersona());
        return personaService.listAllPersona();
    }

    @GetMapping("/sort/{dateofbirth}")
    public ResponseEntity<List<Persona>> getSort(@PathVariable("dateofbirth") String dateOfBirth) throws JsonProcessingException {
        objectMapper.writeValueAsString(personaService.sortBirth(dateOfBirth));
        return new ResponseEntity<>(personaService.sortBirth(dateOfBirth),
                HttpStatus.OK);
    }

    @PostMapping("/add")
    public void create(@RequestParam("firstname") String firstName,
                       @RequestParam("lastname") String lastName,
                       @RequestParam("middlename") String middleName,
                       @RequestParam("dateofbirth") String dateOfBirth) {

        Persona persona = new Persona(firstName, lastName, middleName,
                dateOfBirth);
        personaService.save(persona);
    }

    @PutMapping("/update")
    public void update(@RequestParam("id") Long id,
                       @RequestParam("firstname") String firstName,
                       @RequestParam("lastname") String lastName,
                       @RequestParam("middlename") String middleName,
                       @RequestParam("dateofbirth") String dateOfBirth) {
        Persona persona = new Persona(id, firstName, lastName, middleName,
                dateOfBirth);
        personaService.update(persona);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        personaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
