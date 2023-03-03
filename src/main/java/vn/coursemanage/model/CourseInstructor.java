package vn.coursemanage.model;

public class CourseInstructor {
    private Long courseId, personId;

    public CourseInstructor(Long courseId, Long personId) {
        this.courseId = courseId;
        this.personId = personId;
    }

    public CourseInstructor() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
