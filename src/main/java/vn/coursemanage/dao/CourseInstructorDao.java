package vn.coursemanage.dao;

import vn.coursemanage.mapper.CourseInstructorMapper;
import vn.coursemanage.model.CourseInstructor;
import vn.coursemanage.model.SearchByFields;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CourseInstructorDao extends BaseDao implements Repository<CourseInstructor> {

    @Override
    public List<CourseInstructor> findAll() {
        String sql = "select * from CourseInstructor as ci "
                + "inner join Person as p on p.PersonID = ci.PersonID "
                + "inner join Course as c on c.CourseID = ci.CourseID";
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
        StringBuilder sql = new StringBuilder("select * from CourseInstructor as ci "
                + "inner join Person as p on p.PersonID = ci.PersonID "
                + "inner join Course as c on c.CourseID = ci.CourseID");
        if (searchMap.size() >= 1) {
            sql.append(" where ");
        }
        AtomicInteger count = new AtomicInteger(0);
        searchMap.forEach(search -> {
            count.getAndIncrement();
            if (search.getSearchKey() instanceof String) {
                sql.append("ci." + search.getFieldName() + " like '%" + search.getSearchKey() + "%'");
            } else {
                sql.append("ci." + search.getFieldName() + " = " + search.getSearchKey() + "");
            }
            if (count.get() != searchMap.size()) {
                sql.append(" and ");
            }
        });
        return query(sql.toString(), new CourseInstructorMapper());
    }

    public Long update(CourseInstructor courseInstructorPrev, CourseInstructor courseInstructorUpdate) {
        update("update courseInstructor set CourseID = ?, PersonId = ? where CourseID = ? and PersonId = ?",
                courseInstructorUpdate.getCourseId(),
                courseInstructorUpdate.getPersonId(),
                courseInstructorPrev.getCourseId(),
                courseInstructorPrev.getPersonId()
        );
        return courseInstructorUpdate.getCourseId();
    }

    @Override
    public Long insert(CourseInstructor courseInstructor) {
        insert("insert into CourseInstructor(personId, CourseID) values(?,?)",
                courseInstructor.getPersonId(), courseInstructor.getCourseId()
        );
        return courseInstructor.getCourseId();
    }

    public void deleteOne(Long courseId, Long personID) {
        update("delete from CourseInstructor where CourseID = ? and personID = ?", courseId, personID);
    }

    @Override
    public Long update(CourseInstructor t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
