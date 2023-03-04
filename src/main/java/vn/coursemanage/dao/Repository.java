package vn.coursemanage.dao;

import vn.coursemanage.model.SearchByFields;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findOne(Long id);

    List<T> findByField(String fieldName, String searchKey);

    List<T> findByFields(List<SearchByFields> searchMap);

    void update(T t);

    void insert(T t);
}
