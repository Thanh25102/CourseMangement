package vn.coursemanage.bll;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.coursemanage.dao.OnsiteCourseDao;
import vn.coursemanage.model.OnsiteCourse;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class OnsiteCourseService extends BaseServices<OnsiteCourse> {
    private static final Logger LOGGER = LogManager.getLogger(OnsiteCourseService.class);
    private final OnsiteCourseDao onsiteCourseDao;
    public OnsiteCourseService(OnsiteCourseDao onsiteCourseDao) {
        super(OnsiteCourse.class);
        this.onsiteCourseDao = onsiteCourseDao;
    }

    public List<OnsiteCourse> findAll() {
        return onsiteCourseDao.findAll();
    }
    @Override
    protected List<OnsiteCourse> findByField(String fieldName, String searchKey) throws NoSuchFieldException {
        return onsiteCourseDao.findByField(fieldName, searchKey);
    }
    @Override
    protected List<OnsiteCourse> findByFields(List<SearchByFields> searchMap) {
        return onsiteCourseDao.findByFields(searchMap);
    }
    public Long saveOrUpdate(OnsiteCourse onsiteCourse) {
        try{
            if (onsiteCourse.getCourseId() != null)
                return onsiteCourseDao.update(onsiteCourse);
            else
                return onsiteCourseDao.insert(onsiteCourse);
        }catch (NullPointerException e){
            LOGGER.error("Update or insert data fail");
            return null;
        }
    }
}
