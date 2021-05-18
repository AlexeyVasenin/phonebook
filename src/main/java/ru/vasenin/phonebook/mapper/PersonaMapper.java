package ru.vasenin.phonebook.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.vasenin.phonebook.domain.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaMapper implements RowMapper<Persona> {
    @Override
    public Persona mapRow(ResultSet resultSet, int i) throws SQLException {
        Persona persona = new Persona();
        persona.setId(resultSet.getLong("id"));
        persona.setFirstName(resultSet.getString("firstname"));
        persona.setLastName(resultSet.getString("lastname"));
        persona.setMiddleName(resultSet.getString("middlename"));
        persona.setDateOfBirth(resultSet.getString("dateofbirth"));
        return persona;
    }
}
