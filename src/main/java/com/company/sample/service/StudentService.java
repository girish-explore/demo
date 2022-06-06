package com.company.sample.service;

import com.company.sample.dao.StudentRepository;
import com.company.sample.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository sRepository;

    public Student saveStudent(Student student){
        return sRepository.save(student);
    }

    public List<Student> saveStudents(List<Student> students){
        return sRepository.saveAll(students);
    }

    public List<Student> getStudents(){
        return sRepository.findAll();
    }

    public Student getStudentById(int id){
        return sRepository.findById(id).orElse(null);
    }

    public  Student getStudentByName(String name){
        return sRepository.findByStudentName(name);
    }

    public String deleteStudent(int id){
        sRepository.deleteById(id);
        return "Student Removed having id"+id;
    }

    public Student updateStudent(Student student){
        Student existingStudent=sRepository.findById(student.getStudentId()).orElse(null);
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setStudentEmail(student.getStudentEmail());
        existingStudent.setStudentAge(student.getStudentAge());
        return sRepository.save(existingStudent);
    }

}
