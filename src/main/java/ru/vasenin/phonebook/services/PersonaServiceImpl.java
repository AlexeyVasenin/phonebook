package ru.vasenin.phonebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasenin.phonebook.domain.Persona;
import ru.vasenin.phonebook.mapper.PersonaMapper;

import java.util.List;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonaServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Persona> listAllPersona() {
        return jdbcTemplate.query("select * from persona",
               new PersonaMapper());
    }

    @Override
    public void save(Persona persona) {
        jdbcTemplate.update("insert into persona (firtsname, lastname, " +
                        "middlename, dateofbirth) values(?,?,?,?)",
                persona.getFirstName(), persona.getLastName(),
                persona.getMiddleName(), persona.getDateOfBirth());
    }

    @Override
    public void update(Persona persona) {
        int checkStatus = jdbcTemplate.update("update persona set firstname = " +
                        "?, lastname = ?, middlename = ?, dateofbirth = ? where id = ?",
                persona.getFirstName(), persona.getLastName(),
                persona.getMiddleName(), persona.getDateOfBirth(), persona.getId());

        if (checkStatus != 0) {
            System.out.println("Данные обновлены для id " + persona.getId());
        } else System.out.println("Такой записи не существует");
    }

    @Override
    public List<Persona> sortBirth(String dateofbirth) {
        return jdbcTemplate.query("select * from persona where persona" +
                        ".dateofbirth=?", new PersonaMapper(), dateofbirth);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from persona where persona.id=?",id);
    }
}
