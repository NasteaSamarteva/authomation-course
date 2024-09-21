package com.example.auto_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SerializationToXml {
    @Test
    public void studentTest() throws JsonProcessingException {
        Student inputStudent = new Student("Anastasia", 25);
        List<String> courses = new ArrayList<String>();
        courses.add("Automation");
        courses.add("Math");


    }
}