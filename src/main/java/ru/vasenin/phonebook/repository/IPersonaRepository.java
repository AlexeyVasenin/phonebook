package ru.vasenin.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasenin.phonebook.domain.Persona;

import java.util.List;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {

}
