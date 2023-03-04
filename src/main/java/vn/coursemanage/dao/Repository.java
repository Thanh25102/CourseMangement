package vn.coursemanage.dao;

import vn.coursemanage.exception.CanNotExecuteException;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findOne(Long id);
    List<T> findByField(String fieldName, String searchKey);
    void update(T t);
    void insert(T t);
}
