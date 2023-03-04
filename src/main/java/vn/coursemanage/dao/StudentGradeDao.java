package vn.coursemanage.dao;

import vn.coursemanage.mapper.StudentGradeMapper;
import vn.coursemanage.model.SearchByFields;
import vn.coursemanage.model.StudentGrade;

import java.util.List;

public class StudentGradeDao extends BaseDao implements Repository<StudentGrade> {

    @Override
    public List<StudentGrade> findAll() {
        String sql = "select * from StudentGrade";
        return query(sql, new StudentGradeMapper());
    }

    @Override
    public StudentGrade findOne(Long id) {
        String sql = "select * from StudentGrade where enrollmentId = ? ";
        List<StudentGrade> studentGrades = query(sql, new StudentGradeMapper(), id);
        return studentGrades != null ? studentGrades.get(0) : null;
    }

    @Override
    public List<StudentGrade> findByField(String fieldName, String searchKey) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from StudentGrade as p");
        sql.append(" where p." + fieldName + " like '%" + searchKey + "%'");

        return query(sql.toString(), new StudentGradeMapper());
    }

    @Override
    public List<StudentGrade> findByFields(List<SearchByFields> searchMap) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from StudentGrade as p");
        searchMap.forEach(search -> sql.append(" where p." + search.getFieldName() + " like '%" + search.getSearchKey() + "%'"));

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
}
