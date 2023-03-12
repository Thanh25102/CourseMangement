package vn.coursemanage.bll;

import vn.coursemanage.dao.CourseInstructorDao;
import vn.coursemanage.model.CourseInstructor;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class CourseInstructorService extends BaseServices<CourseInstructor> {

    private final CourseInstructorDao courseInstructorDao;

    public CourseInstructorService(CourseInstructorDao courseInstructorDao) {
        super(CourseInstructor.class);
        this.courseInstructorDao = courseInstructorDao;
    }

    public List<CourseInstructor> findAll() {
        return courseInstructorDao.findAll();
    }

    public Long insert(CourseInstructor courseInstructor) {
        return courseInstructorDao.insert(courseInstructor);
    }
    
    public Long update(CourseInstructor courseInstructorPrev, CourseInstructor courseInstructorUpdate) {
        return courseInstructorDao.update(courseInstructorPrev, courseInstructorUpdate);
    }

    @Override
    protected List<CourseInstructor> findByField(String fieldName, String searchKey) {
        return courseInstructorDao.findByField(fieldName, searchKey);
    }

    @Override
    protected List<CourseInstructor> findByFields(List<SearchByFields> searchMap) {
        return courseInstructorDao.findByFields(searchMap);
    }

    public void deleteOne(Long courseId, Long personID) {
        courseInstructorDao.deleteOne(courseId, personID);
    }
}
