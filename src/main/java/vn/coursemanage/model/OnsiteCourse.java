package vn.coursemanage.model;

import java.util.Date;

public class OnsiteCourse {
    private Long courseID;
    private String location;
    private Integer days;
    private Date time;

    public OnsiteCourse(Long courseID, String location, Integer days, Date time) {
        this.courseID = courseID;
        this.location = location;
        this.days = days;
        this.time = time;
    }

    public OnsiteCourse() {
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
