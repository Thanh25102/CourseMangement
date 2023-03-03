package vn.coursemanage.dao;

import java.util.List;

import vn.coursemanage.mapper.CourseMapper;
import vn.coursemanage.model.Course;

public class CourseDao extends AbstractParentDao {
	public CourseDao() {
	}
	public List<Course> findCourse(){
		String sql = "select * from course";
		return query(sql, new CourseMapper());
	}

}
