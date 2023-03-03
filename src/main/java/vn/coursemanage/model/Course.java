package vn.coursemanage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Course {
	private Long courseId;
	private String title;
	private Double credits;
	private Long departmentId;

	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(Long courseId, String title, Double credits, Long departmentId) {
		this.courseId = courseId;
		this.title = title;
		this.credits = credits;
		this.departmentId = departmentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getCredits() {
		return credits;
	}

	public void setCredits(Double credits) {
		this.credits = credits;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Course{" +
				"courseId=" + courseId +
				", title='" + title + '\'' +
				", credits=" + credits +
				", departmentId=" + departmentId +
				'}';
	}
}
