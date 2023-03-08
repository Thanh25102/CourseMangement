package vn.coursemanage.mapper;

import vn.coursemanage.model.OnlineCourse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OnlineCourseMapper implements RowMapper<OnlineCourse> {

    @Override
    public OnlineCourse mapRow(ResultSet rs) {
        try {
            var onlineCourse = OnlineCourse.builder()
                    .courseId(rs.getLong("CourseId"))
                    .departmentId(rs.getLong("departmentId"))
                    .title(rs.getString("title"))
                    .credits(rs.getDouble("credits"))
                    .url(rs.getString("url"))
                    .build();
            return onlineCourse;
        } catch (SQLException e) {
            return null;
        }
    }
}
