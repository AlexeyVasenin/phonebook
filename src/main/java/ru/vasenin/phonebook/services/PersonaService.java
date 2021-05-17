package ru.vasenin.phonebook.services;

import ru.vasenin.phonebook.domain.Persona;

import java.util.List;

public interface PersonaService {

    void save(Persona persona);

    void update(Persona persona);

    List<Persona> listAllPersona();

    Persona getOne();
}
