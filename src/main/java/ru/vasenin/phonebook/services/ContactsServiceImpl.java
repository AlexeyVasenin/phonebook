package ru.vasenin.phonebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasenin.phonebook.domain.Contacts;

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
        return jdbcTemplate.query("select * from contacts",
                (resultSet, i) -> {
                    Contacts contacts = new Contacts();
                    contacts.setId(resultSet.getLong("id"));
                    contacts.setEmail(resultSet.getString("email"));
                    contacts.setNumber(resultSet.getInt("number_tel"));
                    contacts.setAddress(resultSet.getString("address"));
                    contacts.setSkype(resultSet.getString("skype"));
                    contacts.setPersonaId(resultSet.getLong("persona_id"));
                    return contacts;
                });
    }

    @Override
    public ResponseEntity<Contacts> update(Contacts contacts) {
        int checkStatus = jdbcTemplate.update("update contacts set email " +
                        "= ?, number_tel = ?, address = ?, skype = ? " +
                        "where id = ?",
                contacts.getEmail(), contacts.getNumber(),
                contacts.getAddress(), contacts.getSkype(),
                contacts.getId());

        if (checkStatus != 0) {
            System.out.println("Данные обновлены для id " + contacts.getId());
        } else System.out.println("Такой записи не существует");
        return null;
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
