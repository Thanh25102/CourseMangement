package vn.coursemanage.bll;

import vn.coursemanage.dao.PersonDao;
import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.NotFoundRecordException;
import vn.coursemanage.model.Person;
import vn.coursemanage.model.SearchByFields;

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
    
    public List<Person> findIntructor() {
        List<Person> persons = findAll();
        return persons.stream().filter(p -> p.getHireDate()!= null).collect(Collectors.toList());
    }

    public Person findOne(Long id){
        return personDao.findOne(id);
    }

    public Long saveOrUpdate(Person person) {
        if (person.getPersonId() != null)
            return personDao.update(person);
        else
            return personDao.insert(person);
    }

    @Override
    protected List<Person> findByField(String fieldName, String searchKey) {
        return personDao.findByField(fieldName, searchKey);
    }

    @Override
    protected List<Person> findByFields(List<SearchByFields> searchMap) {
        return personDao.findByFields(searchMap);
    }
    
    public  List<Person> searchByFieldsForStudent(List<SearchByFields> searchMap) throws NotFoundRecordException, FieldNotValidException, NoSuchFieldException {
        List<Person> persons = super.searchByFields(searchMap);
        return persons.stream().filter(p -> p.getEnrollmentDate()!= null).collect(Collectors.toList());
    }
    
    public  List<Person> searchByFieldsForIntructor(List<SearchByFields> searchMap) throws NotFoundRecordException, FieldNotValidException, NoSuchFieldException {
        List<Person> persons = super.searchByFields(searchMap);
        return persons.stream().filter(p -> p.getHireDate()!= null).collect(Collectors.toList());
    }

}
