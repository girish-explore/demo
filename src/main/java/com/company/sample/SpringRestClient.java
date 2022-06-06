package com.company.sample;

import com.company.sample.dto.Student;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpringRestClient {
    private static final String GET_STUDENTS_ENDPOINT_URL = "http://localhost:9191/api/student/students";
    private static final String GET_STUDENT_ENDPOINT_URL = "http://localhost:9191/api/student//studentById/{id}";
    private static final String CREATE_STUDENT_ENDPOINT_URL = "http://localhost:9191/api/student/addStudent";
    private static final String UPDATE_STUDENT_ENDPOINT_URL = "http://localhost:9191/api/student/update";
    private static final String DELETE_STUDENT_ENDPOINT_URL = "http://localhost:9191/api/student/delete";
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringRestClient springRestClient = new SpringRestClient();
        
        springRestClient.createStudent();
       
        springRestClient.getStudentById();

        springRestClient.getStudents();

        springRestClient.updateStudent();

        springRestClient.deleteStudent();
    }

    private void getStudents() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(GET_STUDENTS_ENDPOINT_URL, HttpMethod.GET, entity,
                String.class);

        System.out.println(result);
    }

    private void getStudentById() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "1");

        RestTemplate restTemplate = new RestTemplate();
        Student result = restTemplate.getForObject(GET_STUDENT_ENDPOINT_URL, Student.class, params);

        System.out.println(result);
    }

    private void createStudent() {

        Student newStudent = new Student();

        RestTemplate restTemplate = new RestTemplate();
        Student result = restTemplate.postForObject(CREATE_STUDENT_ENDPOINT_URL, newStudent, Student.class);

        System.out.println(result);
    }

    private void updateStudent() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "1");
        Student updatedStudent = new Student();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(UPDATE_STUDENT_ENDPOINT_URL, updatedStudent, params);
    }

    private void deleteStudent() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "1");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(DELETE_STUDENT_ENDPOINT_URL, params);
    }
}
