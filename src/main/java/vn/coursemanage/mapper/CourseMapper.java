package vn.coursemanage.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import vn.coursemanage.model.Course;

public class CourseMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs) {
		try {
			Course course = new Course();
			course.setCourseId(rs.getLong("CourseID"));
			course.setTitle(rs.getString("Title"));
			course.setCredits(rs.getDouble("Credits"));
			course.setDepartmentId(rs.getLong("DepartmentID"));
			return course;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
