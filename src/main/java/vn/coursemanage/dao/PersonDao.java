package vn.coursemanage.dao;

import vn.coursemanage.mapper.PersonMapper;
import vn.coursemanage.model.Person;

import java.util.List;

public class PersonDao extends AbstractParentDao implements Repository<Person>{
    public Person findOne(Long id) {
        List<Person> person = query("select * from Person where PersonID = ?", new PersonMapper(), id);
        return person != null ? person.get(0) : null;
    }
    public List<Person> findAll() {
        return query("select * from Person", new PersonMapper());
    }
    public List<Person> findByField(String fieldName, String searchKey) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from Person as p");
        sql.append(" where p." + fieldName + " like '%" + searchKey + "%'");

        return query(sql.toString(), new PersonMapper());
    }
    public void update(Person person) {
        update("update Person set LastName = ?, FirstName = ?, HireDate = ?, EnrollmentDate = ? where PersonID = ?",
                person.getLastName(), person.getFirstName(), person.getHireDate(), person.getEnrollmentDate(),
                person.getPersonId());
    }
    public void insert(Person person) {
        update("insert into Person(LastName,FirstName,HireDate,EnrollmentDate) values(?,?,?,?)", person.getLastName(),
                person.getFirstName(), person.getHireDate(), person.getEnrollmentDate());
    }
}
