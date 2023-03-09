package vn.coursemanage.mapper;

import vn.coursemanage.model.CourseInstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseInstructorMapper implements RowMapper<CourseInstructor> {
    @Override
    public CourseInstructor mapRow(ResultSet rs) {
        var courseInstructor = new CourseInstructor();
        try {
            courseInstructor.setCourseId(rs.getLong("CourseID"));
            courseInstructor.setPersonId(rs.getLong("PersonID"));
            return courseInstructor;
        } catch (SQLException e) {
            return null;
        }
    }
}
