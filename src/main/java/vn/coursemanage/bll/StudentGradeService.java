package vn.coursemanage.bll;

import vn.coursemanage.model.SearchByFields;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.coursemanage.dao.StudentGradeDao;
import vn.coursemanage.model.StudentGrade;

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

//    public Long saveOrUpdate(StudentGrade studentGrade) {
//        
//    }
    @Override
    protected List<StudentGrade> findByField(String fieldName, String searchKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<StudentGrade> findByFields(List<SearchByFields> searchMap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void deleteOne(Long enrollmentId) {
        studentGradeDao.deleteOne(enrollmentId);
    }

}
