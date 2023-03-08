package vn.coursemanage.dao;

import vn.coursemanage.model.SearchByFields;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findOne(Long id);

    List<T> findByField(String fieldName, Object searchKey);

    List<T> findByFields(List<SearchByFields> searchMap);

    Long update(T t);

    Long insert(T t);
}
