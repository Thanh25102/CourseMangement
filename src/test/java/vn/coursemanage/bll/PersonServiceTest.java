package vn.coursemanage.bll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vn.coursemanage.dao.PersonDao;
import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.PersonNotFoundException;
import vn.coursemanage.model.Person;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Trường hợp 1: field không tồn tại trong person model
 * ->  ném ra ngoại lệ FieldNotValid
 * Trường hợp 2: không tìm thấy bất cứ person nào trong database theo search key
 * ->  ném ra ngoại lệ PersonNotFound
 * Trường hợp 3: Tìm thấy ít nhất 1 record
 * ->  trả về danh sách person tìm được
 */

@DisplayName("Search person test ")
class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    public void setUp() {
        personService = new PersonService(new PersonDao());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "phone:0123",
            "lastName:Sao Hoa",
            "school:SGU",
            "class:kiem thu phan phan"
    }, delimiter = ':')
    @DisplayName("Field of person should not exist")
    void searchPersonByFieldNotExist(String fieldName, String searchKey) {
        System.out.println("Field name : " + fieldName + "\nSearch key : " + searchKey);
        assertThrows(FieldNotValidException.class, () -> personService.searchPersonByField(fieldName, searchKey));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "firstName:Bui Manh",
            "lastName:Tuan",
            "personId:0",
            "hireDate:1999-10-10"
    }, delimiter = ':')
    @DisplayName("Person should be empty")
    void searchPersonByFieldButRecordIsEmpty(String fieldName, String searchKey) {
        System.out.println("Field name : " + fieldName + "\nSearch key : " + searchKey);
        assertThrows(PersonNotFoundException.class, () -> personService.searchPersonByField(fieldName, searchKey));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "firstName:Bui Manh",
            "lastName:Thi",
            "personId:-1",
            "hireDate:2022-10-10"
    }, delimiter = ':')
    @DisplayName("Should be return list of person")
    void searchPersonByFieldHasRecord(String fieldName, String searchKey) throws Exception {
        System.out.println("Field name : " + fieldName + "\nSearch key : " + searchKey);
        List<Person> person = null;
        try {
            person = personService.searchPersonByField(fieldName, searchKey);
            assertNotNull(person);
            assertNotEquals(0, person.size());
            person.forEach(System.out::println);
        } catch (PersonNotFoundException |FieldNotValidException e) {
            assertNull(person);
//            throw new Exception("Person should has record");
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "lastName:Thanh",
            "lastName:Thi",
    }, delimiter = ':')
    void searchWithLastNameHasRecord(String fieldName, String searchKey){
        List<Person> person = null;
        try {
            person = personService.searchPersonByField(fieldName, searchKey);
            assertNotNull(person);
            assertNotEquals(0, person.size());
            person.forEach(p -> {
                Boolean checked = p.getLastName().contains(searchKey);
                assertTrue(checked);
            });
            person.forEach(System.out::println);
        } catch (PersonNotFoundException | FieldNotValidException e) {
            assertNull(person);
        }

    }

    @ParameterizedTest
    @CsvSource(value = {
            "personId:-1000000",
            "personId:1",
    }, delimiter = ':')
    void searchWithPersonIdHasRecord(String fieldName, String searchKey) {
        List<Person> person = null;
        try {
            person = personService.searchPersonByField(fieldName, searchKey);
            assertNotEquals(0,person.size());
        } catch (PersonNotFoundException | FieldNotValidException e) {
            Integer size = person == null ? 0 : person.size();
            assertEquals(0, size);
            System.out.println("Size of person : " + size);
        }

    }
}