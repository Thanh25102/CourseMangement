package vn.coursemanage.bll;

import vn.coursemanage.dao.PersonDao;
import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.NotFoundRecordException;
import vn.coursemanage.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonService extends BaseServices<Person> {
    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        super(Person.class);
        this.personDao = personDao;
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public List<Person> findStudent() {
        List<Person> persons = findAll();

        return persons.stream().filter(p -> p.getEnrollmentDate() != null).collect(Collectors.toList());
    }

    @Override
    public List<Person> findByField(String fieldName, String searchKey) throws FieldNotValidException, NotFoundRecordException {
        return searchByField(fieldName, searchKey);
    }
}
