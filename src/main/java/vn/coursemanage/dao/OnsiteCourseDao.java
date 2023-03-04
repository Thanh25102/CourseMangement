package vn.coursemanage.dao;

import vn.coursemanage.mapper.OnsiteCourseMapper;
import vn.coursemanage.model.OnsiteCourse;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class OnsiteCourseDao extends BaseDao implements Repository<OnsiteCourse> {
    @Override
    public List<OnsiteCourse> findAll() {
        String sql = "select * from onsite";
        return query(sql, new OnsiteCourseMapper());
    }

    @Override
    public OnsiteCourse findOne(Long id) {
        String sql = "select * from onsite where courseId = ?";
        List<OnsiteCourse> onsiteCourses = query(sql, new OnsiteCourseMapper(), id);
        return onsiteCourses != null ? onsiteCourses.get(0) : null;
    }

    @Override
    public List<OnsiteCourse> findByField(String fieldName, String searchKey) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from onsite as p");
        sql.append(" where p." + fieldName + " like '%" + searchKey + "%'");

        return query(sql.toString(), new OnsiteCourseMapper());
    }

    @Override
    public List<OnsiteCourse> findByFields(List<SearchByFields> searchMap) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from onsite as p");
        searchMap.forEach(search -> sql.append(" where p." + search.getFieldName() + " like '%" + search.getSearchKey() + "%'"));


        return query(sql.toString(), new OnsiteCourseMapper());
    }

    @Override
    public Long update(OnsiteCourse onsiteCourse) {
        update("update onsiteCourse set location = ?, days = ?, time = ? where CourseID = ?",
                onsiteCourse.getLocation(), onsiteCourse.getDays(), onsiteCourse.getTime(), onsiteCourse.getCourseID()
        );
        return onsiteCourse.getCourseID();
    }

    @Override
    public Long insert(OnsiteCourse onsiteCourse) {
        return Long.valueOf(insert("insert into onsiteCourse(location, days, time) values(?,?,?)",
                onsiteCourse.getLocation(), onsiteCourse.getDays(), onsiteCourse.getTime()
        ));
    }
}
