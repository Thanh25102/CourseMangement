package vn.coursemanage.dao;

import vn.coursemanage.mapper.CourseInstructorMapper;
import vn.coursemanage.model.CourseInstructor;

import java.util.List;

public class CourseInstructorDao extends AbstractParentDao implements Repository<CourseInstructor> {
    @Override
    public List<CourseInstructor> findAll() {
        String sql = "select * from CourseInstructor";
        return query(sql, new CourseInstructorMapper());
    }
    @Override
    public CourseInstructor findOne(Long personId) {
        String sql = "select * from CourseInstructor where personId = ? ";
        List<CourseInstructor> courseInstructors = query(sql, new CourseInstructorMapper(), personId);
        return courseInstructors != null ? courseInstructors.get(0) : null;
    }
    @Override
    public List<CourseInstructor> findByField(String fieldName, String searchKey) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from CourseInstructor as p");
        sql.append(" where p." + fieldName + " like '%" + searchKey + "%'");

        return query(sql.toString(), new CourseInstructorMapper());
    }
    @Override
    public void update(CourseInstructor courseInstructor) {
        update("update courseInstructor set personId = ? where CourseID = ?",
                courseInstructor.getPersonId(), courseInstructor.getCourseId()
        );
    }
    @Override
    public void insert(CourseInstructor courseInstructor) {
        update("insert into CourseInstructor(personId, CourseID) values(?,?)",
                courseInstructor.getPersonId(),courseInstructor.getCourseId()
        );
    }
}
