package com.github.lumunix.jowont.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitTestSuitesUnitTests {

    @Test
    public void noArgsConstructor(){
        JUnitTestSuites jUnitTestSuites = new JUnitTestSuites();
        assertEquals(0,jUnitTestSuites.getErrors(),"The errors should have been 0");
        assertEquals(0,jUnitTestSuites.getFailures(),"The failures should have been 0");
        assertNull(jUnitTestSuites.getName(),"The name should have been null");
        assertEquals(0,jUnitTestSuites.getTests(),"The tests should have been 0");
        assertEquals(0,jUnitTestSuites.getTime(),"The time should have been 0");

    }

    @Test
    public void getterAndSetterAndToStringOperation(){
        JUnitTestSuites jUnitTestSuites = new JUnitTestSuites();
        jUnitTestSuites.setErrors(3);
        jUnitTestSuites.setFailures(2);
        jUnitTestSuites.setName("TestName");
        jUnitTestSuites.setTests(8);
        jUnitTestSuites.setTime(5.0);


        assertEquals(3,jUnitTestSuites.getErrors(),"The errors to be set");
        assertEquals(2,jUnitTestSuites.getFailures(),"The failures should be set");
        assertEquals("TestName",jUnitTestSuites.getName(),"The name should be set");
        assertEquals(8,jUnitTestSuites.getTests(),"The tests should be set");
        assertEquals(5.0,jUnitTestSuites.getTime(),"The time should have been set");
        assertTrue(jUnitTestSuites.toString().length() > 0);

    }
}
