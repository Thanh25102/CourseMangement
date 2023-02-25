package vn.coursemanage.model;

public class CourseInstructor {
    private Long courseID, personID;

    public CourseInstructor(Long courseID, Long personID) {
        this.courseID = courseID;
        this.personID = personID;
    }

    public CourseInstructor() {
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }
}
