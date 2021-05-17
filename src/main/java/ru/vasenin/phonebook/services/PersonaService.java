package ru.vasenin.phonebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasenin.phonebook.domain.Persona;
import ru.vasenin.phonebook.repository.IPersonaRepository;

import java.util.List;

@Service
@Transactional
public class PersonaService {
    private final IPersonaRepository iPersonaRepository;

    @Autowired
    public PersonaService(IPersonaRepository iPersonaRepository) {
        this.iPersonaRepository = iPersonaRepository;
    }

    public void creat(Persona persona) {
        try {
            iPersonaRepository.save(persona);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Persona> readAll() {
        return iPersonaRepository.findAll();
    }


    //List<Persona> readFullName(String firstname, String lastname,
    //                           String middlename) {
    //    return iPersonaRepository.findAll(new Persona(firstname, lastname,
    //            middlename));
    //}
    //
    //List<Persona> readDateOfBirth(String date) {
    //    return iPersonaRepository.findAll(new Persona(date));
    //}

}
