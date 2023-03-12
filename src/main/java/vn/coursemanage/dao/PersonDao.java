package vn.coursemanage.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.coursemanage.mapper.PersonMapper;
import vn.coursemanage.model.Person;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class PersonDao extends BaseDao implements Repository<Person> {

    private static final Logger LOGGER = LogManager.getLogger(PersonDao.class);

    public Person findOne(Long id) {
        List<Person> person = query("select * from Person where PersonID = ?", new PersonMapper(), id);
        return person != null ? person.get(0) : null;
    }

    public List<Person> findAll() {
        return query("select * from Person", new PersonMapper());
    }

    public List<Person> findByField(String fieldName, Object searchKey) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from Person as p");

        sql.append(" where p." + fieldName + " like '%" + searchKey + "%'");

        return query(sql.toString(), new PersonMapper());
    }

    @Override
    public List<Person> findByFields(List<SearchByFields> searchMap) {

        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from Person as p where");

        int count = 0;
        for (SearchByFields search : searchMap) {
            count++;
            sql.append(" p." + search.getFieldName() + " like '%" + search.getSearchKey() + "%'");

            if (count != searchMap.size()) sql.append(" and ");
        }

        return query(sql.toString(), new PersonMapper());
    }

    public Long update(Person person) {
        update("update Person set LastName = ?, FirstName = ?, HireDate = ?, EnrollmentDate = ? where PersonID = ?",
                person.getLastName(), 
                person.getFirstName(), 
                person.getHireDate(), 
                person.getEnrollmentDate(),
                person.getPersonId());
        return person.getPersonId();
    }

    public Long insert(Person person) {
        return Long.valueOf(insert("insert into Person(LastName,FirstName,HireDate,EnrollmentDate) values(?,?,?,?)", 
                person.getLastName(),
                person.getFirstName(), 
                person.getHireDate(), 
                person.getEnrollmentDate()));
    }

    public void deleteOne(Long id) {
        update("delete from StudentGrade where StudentID = ?", id);
        update("delete from CourseInstructor where PersonID = ?", id);
        update("delete from Person where PersonID = ?", id);
    }
}
