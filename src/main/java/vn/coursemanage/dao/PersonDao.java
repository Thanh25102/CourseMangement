package vn.coursemanage.dao;


import vn.coursemanage.model.Person;
import vn.coursemanage.mapper.PersonMapper;

import java.util.List;

public class PersonDao extends AbstractParentDao {
    public Person findOneStudent(Integer id) {
        return query("select * from Person where PersonID = ?", new PersonMapper(), id).get(0);
    }

    public List<Person> findPerson() {
        return query("select * from Person", new PersonMapper());
    }

    public void updatePerson(Person person) {
        update("update Person set LastName = ?, FirstName = ?, HireDate = ?, EnrollmentDate = ? where PersonID = ?",
                person.getLastName(), person.getFirstName(), person.getHireDate(), person.getEnrollmentDate(), person.getPersonId());
    }

    public void insertPerson(Person person) {
        update("insert into Person(LastName,FirstName,HireDate,EnrollmentDate) values(?,?,?,?)",
                person.getLastName(), person.getFirstName(), person.getHireDate(), person.getEnrollmentDate());
    }
}
