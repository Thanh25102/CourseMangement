package vn.coursemanage.bll;

import java.util.List;

import vn.coursemanage.dao.CourseDao;
import vn.coursemanage.model.Course;

public class CourseService {
	private final CourseDao courseDao;
	
	public CourseService (CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	public List<Course> getAll(){
		return courseDao.findCourse();
	}

}
