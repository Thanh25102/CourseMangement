package vn.coursemanage.dao;

import vn.coursemanage.mapper.CourseInstructorMapper;
import vn.coursemanage.model.CourseInstructor;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class CourseInstructorDao extends BaseDao implements Repository<CourseInstructor> {
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
    public List<CourseInstructor> findByFields(List<SearchByFields> searchMap) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from CourseInstructor as p");
        searchMap.forEach(search -> sql.append(" where p." + search.getFieldName() + " like '%" + search.getSearchKey() + "%'"));

        return query(sql.toString(), new CourseInstructorMapper());
    }

    @Override
    public Long update(CourseInstructor courseInstructor) {
        update("update courseInstructor set personId = ? where CourseID = ?",
                courseInstructor.getPersonId(), courseInstructor.getCourseId()
        );
        return courseInstructor.getCourseId();
    }

    @Override
    public Long insert(CourseInstructor courseInstructor) {
        return Long.valueOf(insert("insert into CourseInstructor(personId, CourseID) values(?,?)",
                courseInstructor.getPersonId(), courseInstructor.getCourseId()
        ));
    }
}
