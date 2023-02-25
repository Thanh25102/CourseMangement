package vn.coursemanage.mapper;

import vn.coursemanage.model.OnsiteCourse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OnsiteCourseMapper implements RowMapper<OnsiteCourse>{
    @Override
    public OnsiteCourse mapRow(ResultSet rs) {
        OnsiteCourse onsiteCourse = new OnsiteCourse();
        try{
            onsiteCourse.setCourseID(rs.getLong("CourseID"));
            onsiteCourse.setLocation(rs.getString("Location"));
            onsiteCourse.setDays(rs.getInt("Days"));
            onsiteCourse.setTime(rs.getDate("Time"));
            return onsiteCourse;
        }catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
