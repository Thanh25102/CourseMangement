package vn.coursemanage.dao;

import vn.coursemanage.mapper.CourseMapper;
import vn.coursemanage.model.Course;

import java.util.List;

public class CourseDao extends AbstractParentDao implements Repository<Course> {
    public List<Course> findAll() {
        String sql = "select * from course";
        return query(sql, new CourseMapper());
    }
    public Course findOne(Long id) {
        List<Course> courses = query("select * from Course where CourseID = ?", new CourseMapper(), id);
        return courses != null ? courses.get(0) : null;
    }
    public List<Course> findByField(String filedName, String searchKey) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from Course as p");
        sql.append(" where p." + filedName + " like '%" + searchKey + "%'");

        return query(sql.toString(), new CourseMapper());
    }
    public void update(Course course) {
        update("update Course set title = ?, credits = ?, departmentId = ? where courseId = ?",
                course.getTitle(), course.getCredits(), course.getDepartmentId(), course.getCourseId()
        );
    }
    public void insert(Course course) {
        update("insert into Course(title,credits,departmentId) values(?,?,?)",
                course.getTitle(), course.getCredits(), course.getDepartmentId()
        );
    }

}
