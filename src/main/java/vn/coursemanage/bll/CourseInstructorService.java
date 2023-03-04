package vn.coursemanage.bll;

import vn.coursemanage.dao.CourseInstructorDao;
import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.NotFoundRecordException;
import vn.coursemanage.model.CourseInstructor;

import java.util.List;

public class CourseInstructorService extends BaseServices<CourseInstructor> {
    private final CourseInstructorDao courseInstructorDao;

    protected CourseInstructorService(CourseInstructorDao courseInstructorDao) {
        super(CourseInstructor.class);
        this.courseInstructorDao = courseInstructorDao;
    }

    @Override
    protected List<CourseInstructor> findByField(String fieldName, String searchKey) throws FieldNotValidException, NotFoundRecordException {
        return courseInstructorDao.findByField(fieldName, searchKey);
    }

    private List<CourseInstructor> findAll() {
        return courseInstructorDao.findAll();
    }
}
