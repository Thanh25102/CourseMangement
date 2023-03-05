/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.coursemanage.model;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Department {
    
    private Long departmentID;
    private String name;
    private Double budget;
    private Date startdate; 
    private String administrator;

    public Department() {
    }

    public Department(Long departmentID, String name, Double budget, Date startdate, String administrator) {
        this.departmentID = departmentID;
        this.name = name;
        this.budget = budget;
        this.startdate = startdate;
        this.administrator = administrator;
    }
    
    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
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
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentID=" + departmentID + ", name=" + name + ", budget=" + budget + ", startdate=" + startdate + ", administrator=" + administrator + '}';
    }
}
