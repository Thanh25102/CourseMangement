package vn.coursemanage.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.coursemanage.mapper.OnsiteCourseMapper;
import vn.coursemanage.model.OnsiteCourse;
import vn.coursemanage.model.SearchByFields;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OnsiteCourseDao extends BaseDao implements Repository<OnsiteCourse> {
    private final static Logger LOGGER = LogManager.getLogger(OnsiteCourseDao.class);

    @Override
    public List<OnsiteCourse> findAll() {
        String sql = "select * from OnsiteCourse as o inner join course as c where o.courseId = c.courseId";
        return query(sql, new OnsiteCourseMapper());
    }

    @Override
    public OnsiteCourse findOne(Long id) {
        String sql = "select * from OnsiteCourse as o inner join course as c where o.courseId = ?";
        List<OnsiteCourse> onsiteCourses = query(sql, new OnsiteCourseMapper(), id);
        return onsiteCourses != null ? onsiteCourses.get(0) : null;
    }


    @Override
    public List<OnsiteCourse> findByField(String fieldName, Object searchKey) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from OnsiteCourse as o inner join course c on o.courseId = c.courseId ");
        if (searchKey instanceof String) {
            sql.append(" where " + fieldName + " like '%" + searchKey + "%'");
        } else {
            sql.append(" where " + fieldName + " = " + searchKey + "");
        }

        return query(sql.toString(), new OnsiteCourseMapper());
    }

    @Override
    public List<OnsiteCourse> findByFields(List<SearchByFields> searchMap) {
        // create sql query statement
        StringBuilder sql = new StringBuilder("select * from OnsiteCourse as o inner join course c on o.courseId = c.courseId ");

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


        return query(sql.toString(), new OnsiteCourseMapper());
    }

    @Override
    public Long update(OnsiteCourse onsiteCourse) {
        update("update onsiteCourse set location = ?, days = ?, time = ? where CourseID = ?",
                onsiteCourse.getLocation(), onsiteCourse.getDays(), onsiteCourse.getTime(), onsiteCourse.getCourseId()
        );
        update("update Course set title = ?, credits = ?, departmentID = ? where CourseID = ?",
                onsiteCourse.getTitle(), onsiteCourse.getCredits(), onsiteCourse.getDepartmentId(), onsiteCourse.getCourseId()
        );
        return onsiteCourse.getCourseId();
    }

    @Override
    public Long insert(OnsiteCourse onsiteCourse) {
        Long id = Long.valueOf(insert("insert into Course(title, credits, departmentId) values(?,?,?)",
                onsiteCourse.getTitle(), onsiteCourse.getCredits(), onsiteCourse.getDepartmentId()
        ));
        insert("insert into onsiteCourse(CourseId,location, days, time) values(?,?,?,?)",
                id, onsiteCourse.getLocation(), onsiteCourse.getDays(), onsiteCourse.getTime()
        );
        return id;
    }
    
    public void deleteOne(Long id) {
        update("delete from OnsiteCourse where CourseID = ?", id.toString());
        update("delete from OnlineCourse where CourseID = ?", id.toString());        
        update("delete from CourseInstructor where CourseID = ?", id.toString());
        update("delete from StudentGrade where CourseID = ?", id.toString());
        update("delete from Course where CourseID = ?", id.toString());
    }
}
