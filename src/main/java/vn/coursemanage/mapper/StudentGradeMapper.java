package vn.coursemanage.mapper;

import vn.coursemanage.model.StudentGrade;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentGradeMapper implements RowMapper<StudentGrade> {
    @Override
    public StudentGrade mapRow(ResultSet rs) {
        try {
            var studentGrade = new StudentGrade();
            studentGrade.setCourseID(rs.getLong("CourseID"));
            studentGrade.setStudentID(rs.getLong("StudentID"));
            studentGrade.setGrade(rs.getFloat("Grade"));
            studentGrade.setEnrollmentID(rs.getLong("EnrollmentID"));
            return studentGrade;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
