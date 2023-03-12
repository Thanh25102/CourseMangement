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
            courseInstructor.setCourseTitle(rs.getString("Title"));            
            courseInstructor.setPersonFullName(rs.getString("FirstName") + rs.getString("LastName"));
            return courseInstructor;
        } catch (SQLException e) {
            return null;
        }
    }
}
