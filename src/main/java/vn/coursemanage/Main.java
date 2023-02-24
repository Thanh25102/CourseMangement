package vn.coursemanage;

import vn.coursemanage.dao.PersonDao;

public class Main {
    public static void main(String[] args) {
        PersonDao repo = new PersonDao();
        repo.findPerson().forEach(System.out::println);
    }
}