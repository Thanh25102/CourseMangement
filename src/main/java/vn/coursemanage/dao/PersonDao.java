package vn.coursemanage.dao;

import vn.coursemanage.mapper.PersonMapper;
import vn.coursemanage.model.Person;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class PersonDao extends BaseDao implements Repository<Person> {
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

    @Override
    public List<Person> findByFields(List<SearchByFields> searchMap) {

        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from Person as p");
        searchMap.forEach(search -> sql.append(" where p." + search.getFieldName() + " like '%" + search.getSearchKey() + "%'"));

        return query(sql.toString(), new PersonMapper());
    }


    public Long update(Person person) {
        update("update Person set LastName = ?, FirstName = ?, HireDate = ?, EnrollmentDate = ? where PersonID = ?",
                person.getLastName(), person.getFirstName(), person.getHireDate(), person.getEnrollmentDate(),
                person.getPersonId());
        return person.getPersonId();
    }

    public Long insert(Person person) {
        return  Long.valueOf(insert("insert into Person(LastName,FirstName,HireDate,EnrollmentDate) values(?,?,?,?)", person.getLastName(),
                person.getFirstName(), person.getHireDate(), person.getEnrollmentDate()));
    }
}
