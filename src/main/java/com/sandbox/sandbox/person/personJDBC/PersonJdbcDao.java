package com.sandbox.sandbox.person.personJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PersonJDBC> findAll() {
        return jdbcTemplate.query("select * from personJDBC",
                //new BeanPropertyRowMapper<Person>(Person.class));
                new PersonRowMapper());
    }

    public PersonJDBC finById(int id) {
        return jdbcTemplate.queryForObject("select * from personJDBC where id=?", new Object[]{id},
                //new BeanPropertyRowMapper<Person>(Person.class));
                new PersonRowMapper());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from personJDBC where id=?", new Object[]{id});
    }

    public int insert(PersonJDBC personJDBC) {
        return jdbcTemplate.update(
                "insert into personJDBC (id, name, location, birth_date, add_date ) " +
                        "values (?, ?, ?, ?, ?);   ",
                new Object[]{personJDBC.getId(), personJDBC.getName(), personJDBC.getLocation(),
                        personJDBC.getBirthDate(), new Timestamp(personJDBC.getAddDate().getTime())});
    }

    public int update(PersonJDBC personJDBC) {
        return jdbcTemplate.update(
                "update personJDBC set name = ? , location = ?, birth_date = ?, add_date = ? "
                        + "where id = ?",
                new Object[]{personJDBC.getName(), personJDBC.getLocation(),
                        personJDBC.getBirthDate(), new Timestamp(personJDBC.getAddDate().getTime()), personJDBC.getId()});
    }

    class PersonRowMapper implements RowMapper<PersonJDBC> {

        @Override
        public PersonJDBC mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            PersonJDBC person = new PersonJDBC();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDate(resultSet.getDate("birth_date"));
            person.setAddDate(resultSet.getTimestamp("add_date"));
            return person;
        }
    }
}
