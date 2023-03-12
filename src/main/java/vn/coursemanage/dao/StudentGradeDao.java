package vn.coursemanage.dao;

import vn.coursemanage.mapper.StudentGradeMapper;
import vn.coursemanage.model.SearchByFields;
import vn.coursemanage.model.StudentGrade;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentGradeDao extends BaseDao implements Repository<StudentGrade> {

    @Override
    public List<StudentGrade> findAll() {
        String sql = " select * from StudentGrade as sd "
                + "inner join Person as p on p.PersonID = sd.StudentID "
                + "inner join Course as c on c.CourseID = sd.CourseID";
        return query(sql, new StudentGradeMapper());
    }

    @Override
    public StudentGrade findOne(Long id) {
        String sql = "select * from StudentGrade where enrollmentId = ? ";
        List<StudentGrade> studentGrades = query(sql, new StudentGradeMapper(), id);
        return studentGrades != null ? studentGrades.get(0) : null;
    }

    @Override
    public List<StudentGrade> findByField(String fieldName, Object searchKey) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from StudentGrade as p");
        if (searchKey instanceof String) {
            sql.append(" where p." + fieldName + " like '%" + searchKey + "%'");
        } else {
            sql.append(" where p." + fieldName + " = " + searchKey + "");
        }
        return query(sql.toString(), new StudentGradeMapper());
    }

    @Override
    public List<StudentGrade> findByFields(List<SearchByFields> searchMap) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from StudentGrade as sd "
                + "inner join Person as p on p.PersonID = sd.StudentID "
                + "inner join Course as c on c.CourseID = sd.CourseID");
        if (searchMap.size() >= 1) {
            sql.append(" where ");
        }
        AtomicInteger count = new AtomicInteger(0);
        searchMap.forEach(search -> {
            count.getAndIncrement();
            if (search.getSearchKey() instanceof String) {
                sql.append("sd." + search.getFieldName() + " like '%" + search.getSearchKey() + "%'");
            } else {
                sql.append("sd." + search.getFieldName() + " = " + search.getSearchKey() + "");
            }
            if (count.get() != searchMap.size()) {
                sql.append(" and ");
            }
        });

        return query(sql.toString(), new StudentGradeMapper());
    }

    @Override
    public Long update(StudentGrade studentGrade) {
        update("update StudentGrade set courseId = ?,studentId = ?,grade = ? where enrollmentId = ?",
                studentGrade.getCourseID(), studentGrade.getStudentID(), studentGrade.getGrade(), studentGrade.getEnrollmentID()
        );
        return studentGrade.getEnrollmentID();
    }

    @Override
    public Long insert(StudentGrade studentGrade) {
        return Long.valueOf(insert("insert into StudentGrade(courseId,studentId,grade) values(?,?,?)",
                studentGrade.getCourseID(), studentGrade.getStudentID(), studentGrade.getGrade()
        ));
    }

    public void deleteOne(Long enrollmentId) {
        update("delete from StudentGrade where EnrollmentID = ?", enrollmentId);
    }
}
