package vn.coursemanage.model;

import lombok.Builder;

public class OnsiteCourse extends Course {
    private String location;
    private Integer days;
    private Long time;

    public OnsiteCourse(String location, Integer days, Long time) {
        this.location = location;
        this.days = days;
        this.time = time;
    }

    @Builder
    public OnsiteCourse(Long courseId, String title, Double credits, Long departmentId, String location, Integer days, Long time) {
        super(courseId, title, credits, departmentId);
        this.location = location;
        this.days = days;
        this.time = time;
    }

    public OnsiteCourse() {
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OnsiteCourse{" +
                " course id=" + getCourseId() +
                ", location='" + location +
                ", title=" + getTitle() +
                ", credits=" + getCredits() +
                ", department id=" + getDepartmentId() +
                ", days=" + days +
                ", time=" + time +
                '}';
    }
}
