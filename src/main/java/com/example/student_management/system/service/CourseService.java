package com.example.student_management.system.service;

import com.example.student_management.system.dto.CourseRequest;
import com.example.student_management.system.entity.Course;
import com.example.student_management.system.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course createCourse(CourseRequest request) {
        Course course = Course.builder()
                .courseName(request.getCourseName())
                .description(request.getDescription())
                .duration(request.getDuration())
                .build();
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course updateCourse(Long id, CourseRequest request) {
        Course course = getCourseById(id);
        course.setCourseName(request.getCourseName());
        course.setDescription(request.getDescription());
        course.setDuration(request.getDuration());
        return courseRepository.save(course);
    }

    public String deleteCourse(Long id) {
        courseRepository.deleteById(id);
        return "Course deleted successfully";
    }
}
