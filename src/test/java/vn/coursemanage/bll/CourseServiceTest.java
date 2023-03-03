package vn.coursemanage.bll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import vn.coursemanage.dao.CourseDao;
import vn.coursemanage.model.Course;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class CourseServiceTest {

    private CourseDao courseDao;
    private CourseService courseService;
    private final List<Course> mockData = List.of(
            new Course(1L,"Test Title",1000.0,2L));

    @BeforeEach
    public void setUp(){
        courseDao = mock(CourseDao.class);
        when(courseDao.findCourse()).thenReturn(mockData);
        courseService = new CourseService(courseDao);
    }

    @Test
    void getAll() {
        assertEquals(courseService.getAll(),mockData);
    }
}