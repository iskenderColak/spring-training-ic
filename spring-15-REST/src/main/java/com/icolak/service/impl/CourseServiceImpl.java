package com.icolak.service.impl;

import com.icolak.dto.CourseDTO;
import com.icolak.entity.Course;
import com.icolak.repository.CourseRepository;
import com.icolak.service.CourseService;
import com.icolak.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = mapperUtil.convert(courseDTO, new Course());
        courseRepository.save(course);
        return courseDTO;
    }

    @Override
    public CourseDTO getCourseById(long courseId) {
        Course course = courseRepository.findById(courseId).get();
        return mapperUtil.convert(course, new CourseDTO());
    }

    @Override
    public List<CourseDTO> getCoursesByCategory(String category) {
        List<Course> courses = courseRepository.findAllByCategory(category);
        return courses.stream()
                .map(course -> mapperUtil.convert(course, new CourseDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> mapperUtil.convert(course, new CourseDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateCourse(long courseId, CourseDTO courseDTO) {
        Course course = mapperUtil.convert(courseDTO, new Course());

        courseRepository.findById(courseId).ifPresent(dbCourse -> {
            dbCourse.setName(course.getName());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setDescription(course.getDescription());
            dbCourse.setRating(course.getRating());

            courseRepository.save(dbCourse);
        });
    }

    @Override
    public void deleteCourseById(long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();
    }
}
