/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.coursemanage.bll;

import vn.coursemanage.dao.DepartmentDao;
import vn.coursemanage.model.Department;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

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
    public Department findOne(Long id){
        return  departmentDAO.findOne(id);
    }

    public Long saveOrUpdate(Department department){
        if(department.getDepartmentID() == null){
            return this.departmentDAO.insert(department);
        }else{
            return this.departmentDAO.update(department);
        }
    }
    @Override
    protected List<Department> findByField(String fieldName, String searchKey) {
        return  departmentDAO.findByField(fieldName,searchKey);
    }

    @Override
    protected List<Department> findByFields(List<SearchByFields> searchMap) {
        return departmentDAO.findByFields(searchMap);
    }
    
}
