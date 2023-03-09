package vn.coursemanage.dao;

import vn.coursemanage.mapper.OnlineCourseMapper;
import vn.coursemanage.model.OnlineCourse;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class OnlineCourseDao extends BaseDao implements Repository<OnlineCourse> {

    @Override
    public List<OnlineCourse> findAll() {
        String sql = "select * from OnlineCourse as o inner join course as c where o.courseId = c.courseId";
        return query(sql, new OnlineCourseMapper());
    }

    @Override
    public OnlineCourse findOne(Long id) {
        String sql = "select * from OnlineCourse as o inner join course as c where o.courseId = ?";
        List<OnlineCourse> onlineCourses = query(sql, new OnlineCourseMapper(), id);
        return onlineCourses != null ? onlineCourses.get(0) : null;
    }

    @Override
    public List<OnlineCourse> findByField(String fieldName, Object searchKey) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from OnlineCourse as p inner join course as c on p.courseId = c.courseId ");
        sql.append(" where " + fieldName + " like '%" + searchKey + "%'");

        return query(sql.toString(), new OnlineCourseMapper());
    }

    @Override
    public List<OnlineCourse> findByFields(List<SearchByFields> searchMap) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from OnlineCourse as p inner join course as c on p.courseId = c.courseId ");
        searchMap.forEach(search -> sql.append(" where " + search.getFieldName() + " like '%" + search.getSearchKey() + "%'"));

        return query(sql.toString(), new OnlineCourseMapper());
    }

    @Override
    public Long update(OnlineCourse onlineCourse) {
        update("update onsiteCourse set url = ? where courseId = ?",
                onlineCourse.getUrl(), onlineCourse.getCourseId()
        );
        update("update Course set title = ?, credits = ?, departmentID = ? where courseId = ?",
                onlineCourse.getTitle(), onlineCourse.getCredits(), onlineCourse.getDepartmentId(), onlineCourse.getCourseId()
        );
        return onlineCourse.getCourseId();
    }

    @Override
    public Long insert(OnlineCourse onlineCourse) {
        Long id = Long.valueOf(insert("insert into Course(title, credits, departmentId) values(?,?,?)",
                onlineCourse.getTitle(), onlineCourse.getCredits(), onlineCourse.getDepartmentId()
        ));
        insert("insert into onlineCourse(CourseId,url) values(?,?,?,?)",
                id, onlineCourse.getCourseId(), onlineCourse.getUrl()
        );
        return id;
    }
}
