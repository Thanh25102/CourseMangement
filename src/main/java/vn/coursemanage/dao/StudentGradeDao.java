package vn.coursemanage.dao;

import vn.coursemanage.mapper.CourseInstructorMapper;
import vn.coursemanage.mapper.StudentGradeMapper;
import vn.coursemanage.model.CourseInstructor;
import vn.coursemanage.model.StudentGrade;

import java.util.List;

public class StudentGradeDao extends AbstractParentDao implements Repository<StudentGrade>{

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
    public void update(StudentGrade studentGrade) {
        update("update StudentGrade set courseId = ?,studentId = ?,grade = ? where enrollmentId = ?",
                studentGrade.getCourseID(),studentGrade.getStudentID(),studentGrade.getGrade(),studentGrade.getEnrollmentID()
        );
    }

    @Override
    public void insert(StudentGrade studentGrade) {
        update("insert into StudentGrade(courseId,studentId,grade) values(?,?,?)",
                studentGrade.getCourseID(),studentGrade.getStudentID(),studentGrade.getGrade()
        );
    }
}