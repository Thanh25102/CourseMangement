/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.coursemanage.dao;

import vn.coursemanage.mapper.DepartmentMapper;
import vn.coursemanage.model.Department;
import vn.coursemanage.model.SearchByFields;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PC
 */
public class DepartmentDao extends BaseDao implements Repository<Department> {

    @Override
    public List<Department> findAll() {
        return query("select * from Department", new DepartmentMapper());
    }

    @Override
    public Department findOne(Long id) {
        String sql = "select * from Department where departmentId = ? ";
        List<Department> departments = query(sql, new DepartmentMapper(),id);
        return departments != null ? departments.get(0) : null;
    }

    @Override
    public List<Department> findByField(String fieldName, Object searchKey) {
        StringBuilder sql = new StringBuilder("select * from Department  ");
        if (searchKey instanceof String) {
            sql.append(" where " + fieldName + " like '%" + searchKey + "%'");
        } else {
            sql.append(" where " + fieldName + " = " + searchKey + "");
        }

        return query(sql.toString(), new DepartmentMapper());
    }

    @Override
    public List<Department> findByFields(List<SearchByFields> searchMap) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from Department ");

        if (searchMap.size() >= 1) {
            sql.append(" where ");
        }
        AtomicInteger count = new AtomicInteger(0);
        searchMap.forEach(search -> {
            count.getAndIncrement();
            if (search.getSearchKey() instanceof String) {
                sql.append(search.getFieldName() + " like '%" + search.getSearchKey() + "%'");
            } else {
                sql.append(search.getFieldName() + " = " + search.getSearchKey() + "");
            }
            if (count.get() != searchMap.size()) sql.append(" and ");
        });
        return query(sql.toString(), new DepartmentMapper());
    }

    @Override
    public Long update(Department department) {
        update("update Department set name = ?, budget = ?, startDate = ? , administrator = ? where departmentId = ?",
            department.getName(),department.getBudget(),department.getStartdate(),department.getAdministrator(),department.getDepartmentID()
        );
        return department.getDepartmentID();
    }

    @Override
    public Long insert(Department department) {
        return Long.valueOf(insert("insert into Department(name,budget, startDate, administrator) values(?,?,?,?)",
                department.getName(),department.getBudget(),department.getStartdate(),department.getAdministrator()
        ));

    }

}
