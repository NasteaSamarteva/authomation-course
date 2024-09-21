package com.example.auto_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SerializationTest {

    @Test
    public void studentTest() throws JsonProcessingException {
        Student inputStudent = new Student("Anastasia", 25);
        List<String> courses = new ArrayList<String>();
        courses.add("Automation");
        courses.add("Math");
        inputStudent.setCourses(courses);
        ObjectMapper objectMapper = new ObjectMapper();

        String studentJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(inputStudent);

        Student outputStudent = objectMapper.readValue(studentJson, Student.class);

        Assertions.assertEquals(inputStudent.getAge(), outputStudent.getAge());
        Assertions.assertEquals(inputStudent.getFullName(), outputStudent.getFullName());
        Assertions.assertEquals(inputStudent.getCourses(), outputStudent.getCourses());
        System.out.println(studentJson);
    }
}