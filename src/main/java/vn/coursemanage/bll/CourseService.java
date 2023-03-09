package vn.coursemanage.bll;

import vn.coursemanage.dao.CourseDao;
import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.NotFoundRecordException;
import vn.coursemanage.model.Course;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class CourseService extends BaseServices<Course> {
    private final CourseDao courseDao;

    public CourseService(CourseDao courseDao) {
        super(Course.class);
        this.courseDao = courseDao;
    }

    public List<Course> findAll(){
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
    public List<Course> searchByField(String fieldName, String searchKey) throws NotFoundRecordException, FieldNotValidException, NoSuchFieldException {
//        return super.searchByField(fieldName, searchKey);
        return null;
    }

    @Override
    public List<Course> searchByFields(List<SearchByFields> searchMap) throws NotFoundRecordException, FieldNotValidException, NoSuchFieldException {
//        return super.searchByFields(searchMap);
        return null;
    }
}
