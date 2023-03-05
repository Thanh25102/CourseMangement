package vn.coursemanage.model;

import java.util.Date;

public class OnsiteCourse extends Course {
    private String location;
    private Integer days;
    private Date time;

    public OnsiteCourse( String location, Integer days, Date time) {
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
