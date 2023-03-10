package vn.coursemanage.dao;

import vn.coursemanage.mapper.OnlineCourseMapper;
import vn.coursemanage.model.OnlineCourse;
import vn.coursemanage.model.SearchByFields;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        if (searchKey instanceof String) {
            sql.append(" where " + fieldName + " like '%" + searchKey + "%'");
        } else {
            sql.append(" where " + fieldName + " = " + searchKey + "");
        }
        return query(sql.toString(), new OnlineCourseMapper());
    }

    @Override
    public List<OnlineCourse> findByFields(List<SearchByFields> searchMap) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from OnlineCourse as p inner join course as c on p.courseId = c.courseId ");
        if (searchMap.size() >= 1) {
            sql.append(" where ");
        }
        AtomicInteger count = new AtomicInteger(0);
        searchMap.forEach(search -> {
            count.getAndIncrement();
            if (search.getSearchKey() instanceof String) {
                sql.append(search.getFieldName() + " like '%" + search.getSearchKey() + "%'");
            } else {
                sql.append(search.getFieldName() + " = " + search.getSearchKey() + "");
            }
            if (count.get() != searchMap.size()) sql.append(" and ");
        });
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
        insert("insert into onlineCourse(CourseId,url) values(?,?)",
                id, onlineCourse.getUrl()
        );
        return id;
    }

    public void deleteOne(Long id) {
        update("delete from OnsiteCourse where CourseID = ?", id);
        update("delete from OnlineCourse where CourseID = ?", id);
        update("delete from CourseInstructor where CourseID = ?", id);
        update("delete from StudentGrade where CourseID = ?", id);
        update("delete from Course where CourseID = ?", id);
    }
}
