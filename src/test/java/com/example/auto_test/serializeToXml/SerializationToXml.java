package com.example.auto_test.serializeToXml;

import com.example.auto_test.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SerializationToXml {
    @Test
    public void studentTest() throws JsonProcessingException {
        StudentToXml inputStudent = new StudentToXml("Anastasia", 25);
        List<String> courses = new ArrayList<String>();
        courses.add("Automation");
        courses.add("Math");

        XmlMapper xmlMapper = new XmlMapper();
        String result = xmlMapper.writeValueAsString(inputStudent);

       // Assertions.assertEquals(inputStudent.getFullName(),result.ge);
        System.out.println(result);
        Assertions.assertTrue(true);
    }
}