package ru.vasenin.phonebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasenin.phonebook.domain.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;
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
        return jdbcTemplate.query("select firstName, lastName, middlename from " +
                "persona", new RowMapper<Persona>() {
            @Override
            public Persona mapRow(ResultSet resultSet, int i) throws SQLException {
                Persona persona = new Persona();
                persona.setFirstName(resultSet.getString("firstname"));
                persona.setLastName(resultSet.getString("lastname"));
                persona.setMiddleName(resultSet.getString("middlename"));
                return persona;
            }
        });
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
}
