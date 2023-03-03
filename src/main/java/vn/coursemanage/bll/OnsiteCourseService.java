package vn.coursemanage.bll;

import java.util.List;

import vn.coursemanage.dao.OnsiteCourseDao;
import vn.coursemanage.exception.FieldNotValidException;
import vn.coursemanage.exception.NotFoundRecordException;
import vn.coursemanage.model.Course;
import vn.coursemanage.model.OnsiteCourse;

public class OnsiteCourseService extends BaseServices<OnsiteCourse>{
	private final OnsiteCourseDao onsiteCourseDao;
	public OnsiteCourseService(OnsiteCourseDao onsiteCourseDao) {
		super(OnsiteCourse.class);
		this.onsiteCourseDao = onsiteCourseDao;
	}
	public List<OnsiteCourse> findAll(){
		return onsiteCourseDao.findAll();
	}
	@Override
	protected List<OnsiteCourse> findByField(String fieldName, String searchKey) throws FieldNotValidException, NotFoundRecordException {
		return onsiteCourseDao.findByField(fieldName,searchKey);
	}

}
