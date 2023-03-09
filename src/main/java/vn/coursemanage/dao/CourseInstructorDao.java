package vn.coursemanage.dao;

import vn.coursemanage.mapper.CourseInstructorMapper;
import vn.coursemanage.model.CourseInstructor;
import vn.coursemanage.model.SearchByFields;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    public List<CourseInstructor> findByField(String fieldName, Object searchKey) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from CourseInstructor as p");
        if (searchKey instanceof String) {
            sql.append(" where " + fieldName + " like '%" + searchKey + "%'");
        } else {
            sql.append(" where " + fieldName + " = " + searchKey + "");
        }
        return query(sql.toString(), new CourseInstructorMapper());
    }

    @Override
    public List<CourseInstructor> findByFields(List<SearchByFields> searchMap) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from CourseInstructor as p");
        if (searchMap.size() >= 1) {
            sql.append(" where ");
        }
        AtomicInteger count = new AtomicInteger(0);
        searchMap.forEach(search -> {
            count.getAndIncrement();
            if (search.getSearchKey() instanceof String) {
                sql.append(search.getFieldName() + " like '%" + search.getSearchKey() + "%'");
            } else {
                sql.append(search.getFieldName() + " = " + search.getSearchKey() + "");
            }
            if (count.get() != searchMap.size()) sql.append(" and ");
        });
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
    
    public void deleteOne(Long courseId, Long personID) {
        update("delete from CourseInstructor where CourseID = ? and personID = ?", courseId.toString(), personID.toString());
    }
}
