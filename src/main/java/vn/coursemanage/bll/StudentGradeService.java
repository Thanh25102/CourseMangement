package vn.coursemanage.bll;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.coursemanage.dao.StudentGradeDao;
import vn.coursemanage.model.SearchByFields;
import vn.coursemanage.model.StudentGrade;

import java.util.List;

public class StudentGradeService extends BaseServices<StudentGrade> {

    private static final Logger LOGGER = LogManager.getLogger(StudentGradeService.class);
    private StudentGradeDao studentGradeDao;

    public StudentGradeService(StudentGradeDao studentGradeDao) {
        super(StudentGrade.class);
        this.studentGradeDao = studentGradeDao;
    }

    public List<StudentGrade> findAll() {
        List<StudentGrade> list = studentGradeDao.findAll();
        list.forEach(i -> LOGGER.info(i.toString()));
        return list;
    }

    public Long saveOrUpdate(StudentGrade studentGrade) {
        if (studentGrade.getEnrollmentID() == null) {
            return this.studentGradeDao.insert(studentGrade);
        } else {
            return this.studentGradeDao.update(studentGrade);
        }
    }

    @Override
    protected List<StudentGrade> findByField(String fieldName, String searchKey) {
        return studentGradeDao.findByField(fieldName, searchKey);
    }

    @Override
    protected List<StudentGrade> findByFields(List<SearchByFields> searchMap) {
        return studentGradeDao.findByFields(searchMap);
    }

    public void deleteOne(Long enrollmentId) {
        studentGradeDao.deleteOne(enrollmentId);
    }

}
