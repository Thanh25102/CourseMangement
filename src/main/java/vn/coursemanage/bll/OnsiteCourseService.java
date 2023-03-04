package vn.coursemanage.bll;

import vn.coursemanage.dao.OnsiteCourseDao;
import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.NotFoundRecordException;
import vn.coursemanage.model.OnsiteCourse;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class OnsiteCourseService extends BaseServices<OnsiteCourse> {
    private final OnsiteCourseDao onsiteCourseDao;

    public OnsiteCourseService(OnsiteCourseDao onsiteCourseDao) {
        super(OnsiteCourse.class);
        this.onsiteCourseDao = onsiteCourseDao;
    }

    public List<OnsiteCourse> findAll() {
        return onsiteCourseDao.findAll();
    }

    @Override
    protected List<OnsiteCourse> findByField(String fieldName, String searchKey){
        return onsiteCourseDao.findByField(fieldName, searchKey);
    }

    @Override
    protected List<OnsiteCourse> findByFields(List<SearchByFields> searchMap) {
        return onsiteCourseDao.findByFields(searchMap);
    }

}
