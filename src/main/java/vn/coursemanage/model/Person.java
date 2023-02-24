package vn.coursemanage.model;

import java.util.Date;

public class Person {
    private Long personId;
    private String firstName;
    private String lastName;
    private Date hireDate;
    private Date enrollmentDate;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Person(Long personId, String firstName, String lastName, Date hireDate, Date enrollmentDate) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.enrollmentDate = enrollmentDate;
    }
    public Person(){}
}
