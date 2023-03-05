/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.coursemanage.bll;

import java.util.List;
import vn.coursemanage.dao.DepartmentDao;
import vn.coursemanage.model.Department;
import vn.coursemanage.model.SearchByFields;

/**
 *
 * @author PC
 */
public class DepartmentService extends BaseServices<Department>{
    private DepartmentDao departmentDAO;

    public DepartmentService(DepartmentDao departmentDAO) {
        super(Department.class);
        this.departmentDAO = departmentDAO;
    }
    public List<Department> findAll() {
        return departmentDAO.findAll();
    }
    @Override
    protected List<Department> findByField(String fieldName, String searchKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<Department> findByFields(List<SearchByFields> searchMap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
