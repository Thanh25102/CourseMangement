/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.coursemanage.model;

import java.util.Date;

/**
 * @author PC
 */
public class Department {

    private Long departmentId;
    private String name;
    private Double budget;
    private Date startDate;
    private String administrator;

    public Department() {
    }

    public Department(Long departmentId, String name, Double budget, Date startDate, String administrator) {
        this.departmentId = departmentId;
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
        this.administrator = administrator;
    }

    public Long getDepartmentID() {
        return departmentId;
    }

    public void setDepartmentID(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Date getStartdate() {
        return startDate;
    }

    public void setStartdate(Date startDate) {
        this.startDate = startDate;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentId=" + departmentId + ", name=" + name + ", budget=" + budget + ", startDate=" + startDate + ", administrator=" + administrator + '}';
    }
}
