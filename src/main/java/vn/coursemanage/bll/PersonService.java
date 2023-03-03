package vn.coursemanage.bll;

import vn.coursemanage.dao.PersonDao;
import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.PersonNotFoundException;
import vn.coursemanage.model.Person;

import java.lang.reflect.Field;
import java.util.List;

public class PersonService extends BaseServices{
    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAll() {
        return personDao.findPerson();
    }

    public List<Person> searchPersonByField(String fieldName, String searchKey) throws PersonNotFoundException, FieldNotValidException {
        // check field is exist in Object class ??
        if (!isObjContainField(Person.class, fieldName))
            throw new FieldNotValidException(fieldName + " isn't exist in class " + Person.class.getSimpleName());

        List<Person> person = personDao.findPersonByField(fieldName, searchKey);

        if (person == null || person.size() == 0)
            throw new PersonNotFoundException("Can't find any person with search key is : " + searchKey);

        return person;
    }

}
