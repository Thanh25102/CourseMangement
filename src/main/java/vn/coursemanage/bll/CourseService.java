package vn.coursemanage.bll;

import vn.coursemanage.dao.CourseDao;
import vn.coursemanage.model.Course;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class CourseService extends BaseServices<Course> {
    private final CourseDao courseDao;

    public CourseService(CourseDao courseDao) {
        super(Course.class);
        this.courseDao = courseDao;
    }

    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    protected List<Course> findByField(String fieldName, String searchKey) throws NoSuchFieldException {
        return courseDao.findByField(fieldName, searchKey);
    }

    @Override
    protected List<Course> findByFields(List<SearchByFields> searchMap) {
        return courseDao.findByFields(searchMap);
    }

    @Override
    public List<Course> searchByField(String fieldName, String searchKey) {
        return courseDao.findByField(fieldName, searchKey);
    }

    @Override
    public List<Course> searchByFields(List<SearchByFields> searchMap) {
        return courseDao.findByFields(searchMap);
    }
}
