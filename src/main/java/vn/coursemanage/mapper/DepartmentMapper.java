/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.coursemanage.mapper;

import vn.coursemanage.model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author PC
 */
public class DepartmentMapper implements RowMapper<Department> {
    @Override
    public Department mapRow(ResultSet rs) {
        try {
            var department = new Department();
            department.setDepartmentID(rs.getLong("departmentID"));
            department.setName(rs.getString("name"));
            department.setBudget(rs.getDouble("budget"));
            department.setStartdate(rs.getDate("startDate"));
            department.setAdministrator(rs.getString("administrator"));
            return department;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
