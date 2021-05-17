package ru.vasenin.phonebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasenin.phonebook.domain.Contacts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ContactsServiceImpl implements ContactsService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactsServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Contacts> listAllContacts() {
        return jdbcTemplate.query("select email, number_tel, address, skype," +
                        "persona_id from contacts",
                new RowMapper<Contacts>() {
            @Override
            public Contacts mapRow(ResultSet resultSet, int i) throws SQLException {
                Contacts contacts = new Contacts();
                contacts.setEmail(resultSet.getString("email"));
                contacts.setNumber(resultSet.getInt("number_tel"));
                contacts.setAddress(resultSet.getString("address"));
                contacts.setSkype(resultSet.getString("skype"));
                contacts.setPersonaId(resultSet.getInt("persona_id"));
                return contacts;
            }
        });
    }

    @Override
    public void add(Contacts contacts) {
        jdbcTemplate.update("insert into contacts (persona_id, email, " +
                        "number_tel, address, skype) value (?,?,?,?,?)",
                contacts.getPersonaId(), contacts.getEmail(),
                contacts.getNumber(), contacts.getAddress(),
                contacts.getSkype());
    }
}
