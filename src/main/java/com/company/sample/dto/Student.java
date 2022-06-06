package com.company.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="student_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String studentName;
    private String studentEmail;
    @Version
    private int studentAge;
    @ManyToMany
    @JoinTable(name="student_course",joinColumns=@JoinColumn(name = "student_id"),inverseJoinColumns=@JoinColumn(name = "course_id"))
    private List<Course> courses;
}
