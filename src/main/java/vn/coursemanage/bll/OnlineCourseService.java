package vn.coursemanage.bll;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.coursemanage.dao.OnlineCourseDao;
import vn.coursemanage.model.OnlineCourse;
import vn.coursemanage.model.SearchByFields;

import java.util.List;

public class OnlineCourseService extends BaseServices<OnlineCourse> {

    private static final Logger LOGGER = LogManager.getLogger(OnlineCourseService.class);
    private final OnlineCourseDao onlineCourseDao;

    public OnlineCourseService(OnlineCourseDao onlineCourseDao) {
        super(OnlineCourse.class);
        this.onlineCourseDao = onlineCourseDao;
    }

    public List<OnlineCourse> findAll() {
        return onlineCourseDao.findAll();
    }

    public Long saveOrUpdate(OnlineCourse onlineCourse) {
        try {
            if (onlineCourse.getCourseId() != null) {
                return onlineCourseDao.update(onlineCourse);
            } else {
                return onlineCourseDao.insert(onlineCourse);
            }
        } catch (NullPointerException e) {
            LOGGER.error("Update or insert data fail");
            return null;
        }
    }

    @Override
    protected List<OnlineCourse> findByField(String fieldName, String searchKey) {
        return onlineCourseDao.findByField(fieldName, searchKey);
    }

    @Override
    protected List<OnlineCourse> findByFields(List<SearchByFields> searchMap) {
        return onlineCourseDao.findByFields(searchMap);
    }

    public void deleteOne(Long id) {
        onlineCourseDao.deleteOne(id);
    }

}
