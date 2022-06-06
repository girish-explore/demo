package com.company.sample.service;

import com.company.sample.dao.CourseRepository;
import com.company.sample.dto.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository cRepository;

    public Course saveCourse(Course course){
        return cRepository.save(course);
    }

    public List<Course> saveCourses(List<Course> courses){
        return cRepository.saveAll(courses);
    }

    public List<Course> getCourses(){
        return cRepository.findAll();
    }

    public Course getCourseById(int id){
        return cRepository.findById(id).orElse(null);
    }

    public String deleteCourse(int id){
        cRepository.deleteById(id);
        return "Course Removed having id"+id;
    }

    public Course updateCourse(Course course){
        Course existingCourse=cRepository.findById(course.getCourseId()).orElse(null);
        existingCourse.setCourseName(course.getCourseName());;
        return cRepository.save(existingCourse);
    }
}
