package vn.coursemanage.mapper;

import vn.coursemanage.model.CourseInstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseInstructorMapper implements RowMapper<CourseInstructor>{
    @Override
    public CourseInstructor mapRow(ResultSet rs) {
        CourseInstructor courseInstructor = new CourseInstructor();
        try {
            courseInstructor.setCourseID(rs.getLong("CourseID"));
            courseInstructor.setPersonID(rs.getLong("PersonID"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
