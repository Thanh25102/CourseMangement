package vn.coursemanage.mapper;

import vn.coursemanage.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs) {
        try {
            Person person = new Person();
            person.setPersonId(rs.getLong("PersonID"));
            person.setFirstName(rs.getString("FirstName"));
            person.setLastName(rs.getString("LastName"));
            person.setHireDate(rs.getDate("HireDate"));
            person.setEnrollmentDate(rs.getDate("EnrollmentDate"));
            return person;
        } catch (SQLException e) {
            return null;
        }
    }
}
