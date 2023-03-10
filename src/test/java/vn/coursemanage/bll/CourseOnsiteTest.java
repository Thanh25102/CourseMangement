package vn.coursemanage.bll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vn.coursemanage.dao.OnsiteCourseDao;
import vn.coursemanage.model.OnsiteCourse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CourseOnsiteTest {

    private OnsiteCourseDao onsiteCourseDao;
    private OnsiteCourseService courseService;
    private final List<OnsiteCourse> mockData = List.of(
            new OnsiteCourse()
    );

    @BeforeEach
    public void setUp() {
        onsiteCourseDao = mock(OnsiteCourseDao.class);
        when(onsiteCourseDao.findAll()).thenReturn(mockData);
        courseService = new OnsiteCourseService(onsiteCourseDao);
    }

    @Test
    void getAll() {
        assertEquals(courseService.findAll(), mockData);
    }
}