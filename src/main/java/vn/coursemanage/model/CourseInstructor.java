package vn.coursemanage.model;

public class CourseInstructor {
    private Long courseId;
    private String courseTitle;
    private Long personId;
    private String personFullName;


    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getPersonFullName() {
        return personFullName;
    }

    public void setPersonFullName(String personFullName) {
        this.personFullName = personFullName;
    }

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
