package vn.coursemanage.model;

import lombok.Builder;

public class OnlineCourse extends Course {
    private String url;

    @Builder
    public OnlineCourse(Long courseId, String title, Double credits, Long departmentId, String url) {
        super(courseId, title, credits, departmentId);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
