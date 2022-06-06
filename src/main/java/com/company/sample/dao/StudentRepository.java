package com.company.sample.dao;

import com.company.sample.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByStudentName(String name);
}
