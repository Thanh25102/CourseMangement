package vn.coursemanage;

import vn.coursemanage.bll.PersonService;
import vn.coursemanage.dao.PersonDao;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        PersonService service = new PersonService(new PersonDao());
        service.findAll().forEach(System.out::println);
    }
}