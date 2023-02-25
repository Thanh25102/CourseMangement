package vn.coursemanage;

import vn.coursemanage.dao.PersonDao;
import vn.coursemanage.model.Person;

public class Main {
    public static void main(String[] args) {
        PersonDao repo = new PersonDao();
        repo.findPersonByField("firstName","u")
                .forEach(System.out::println);
        repo.findPerson().forEach(System.out::println);
    }
}