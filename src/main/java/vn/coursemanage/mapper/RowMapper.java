package vn.coursemanage.mapper;


import java.sql.ResultSet;

public interface RowMapper<T> {
    T mapRow(ResultSet rs);
}