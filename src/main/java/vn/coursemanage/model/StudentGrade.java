package vn.coursemanage.model;

public class StudentGrade {
    private Long enrollmentID, courseID, studentID;
    private float grade;

    public StudentGrade(Long enrollmentID, Long courseID, Long studentID, float grade) {
        this.enrollmentID = enrollmentID;
        this.courseID = courseID;
        this.studentID = studentID;
        this.grade = grade;
    }

    public StudentGrade() {
    }

    public Long getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(Long enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentGrade{" + "enrollmentID=" + enrollmentID + ", courseID=" + courseID + ", studentID=" + studentID + ", grade=" + grade + '}';
    }
}
