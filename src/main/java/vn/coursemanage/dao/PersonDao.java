package vn.coursemanage.dao;

import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.mapper.PersonMapper;
import vn.coursemanage.model.Person;

import java.util.List;

public class PersonDao extends AbstractParentDao {
	private static PersonDao ins = null;

	public PersonDao() {
	}

	public static PersonDao getIns() {
		return ins == null ? new PersonDao() : ins;
	}

	public Person findOneStudent(Integer id) {
		return query("select * from Person where PersonID = ?", new PersonMapper(), id).get(0);
	}

	public List<Person> findPerson() {
		return query("select * from Person", new PersonMapper());
	}

	public List<Person> findPersonByField(String filedName, String searchKey)  {
		// create sql query statement
		StringBuilder sql = new StringBuilder("select * from Person as p");
		sql.append(" where p." + filedName + " like '%" + searchKey + "%'");

		return query(sql.toString(), new PersonMapper());
	}

	public void updatePerson(Person person) {
		update("update Person set LastName = ?, FirstName = ?, HireDate = ?, EnrollmentDate = ? where PersonID = ?",
				person.getLastName(), person.getFirstName(), person.getHireDate(), person.getEnrollmentDate(),
				person.getPersonId());
	}

	public void insertPerson(Person person) {
		update("insert into Person(LastName,FirstName,HireDate,EnrollmentDate) values(?,?,?,?)", person.getLastName(),
				person.getFirstName(), person.getHireDate(), person.getEnrollmentDate());
	}
}
