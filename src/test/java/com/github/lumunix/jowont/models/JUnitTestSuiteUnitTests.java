package com.github.lumunix.jowont.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTestSuiteUnitTests {

    @Test
    public void noArgsConstructor(){
        JUnitTestSuite jUnitTestSuite = new JUnitTestSuite();
        assertEquals(0,jUnitTestSuite.getErrors(),"The errors should have been 0");
        assertEquals(0,jUnitTestSuite.getFailures(),"The failures should have been 0");
        assertNull(jUnitTestSuite.getHostname(),"The hostname should have been null");
        assertNull(jUnitTestSuite.getName(),"The name should have been null");
        assertEquals(0,jUnitTestSuite.getSkipped(),"The skipped should have been 0");
        assertEquals(0,jUnitTestSuite.getTests(),"The tests should have been 0");
        assertEquals(0,jUnitTestSuite.getTime(),"The time should have been 0");
        assertNull(jUnitTestSuite.getTimestamp(),"The timestamp should have been null");
        assertNull(jUnitTestSuite.getProperties(),"The properties should have been null");
        assertNull(jUnitTestSuite.getTestCases(),"The testcases should have been null");
        assertNull(jUnitTestSuite.getSystemErr(),"The systemerr should have been null");
        assertNull(jUnitTestSuite.getSystemOut(),"The systemout should have been null");
    }

    @Test
    public void getterAndSetterAndToStringOperation(){
        JUnitTestSuite jUnitTestSuite = new JUnitTestSuite();

        jUnitTestSuite.setErrors(3);
        jUnitTestSuite.setFailures(2);
        jUnitTestSuite.setHostname("TestHostname");
        jUnitTestSuite.setName("TestName");
        jUnitTestSuite.setSkipped(3);
        jUnitTestSuite.setTests(8);
        jUnitTestSuite.setTime(5.0);
        jUnitTestSuite.setTimestamp("Timestamp");
        jUnitTestSuite.setProperties(new ArrayList<>());
        jUnitTestSuite.setTestCases(new ArrayList<>());
        jUnitTestSuite.setSystemErr("TestSystemError");
        jUnitTestSuite.setSystemOut("TestSystemOut");

        assertEquals(3,jUnitTestSuite.getErrors(),"The errors to be set");
        assertEquals(2,jUnitTestSuite.getFailures(),"The failures should be set");
        assertEquals("TestHostname",jUnitTestSuite.getHostname(),"The hostname should be set");
        assertEquals("TestName",jUnitTestSuite.getName(),"The name should be set");
        assertEquals(3,jUnitTestSuite.getSkipped(),"The skipped should be set");
        assertEquals(8,jUnitTestSuite.getTests(),"The tests should be set");
        assertEquals(5.0,jUnitTestSuite.getTime(),"The time should have been set");
        assertEquals("Timestamp",jUnitTestSuite.getTimestamp(),"The timestamp should be set");
        assertNotNull(jUnitTestSuite.getProperties(),"Expected properties initialized");
        assertNotNull(jUnitTestSuite.getTestCases(),"Expected testcases initialized");
        assertEquals("TestSystemError",jUnitTestSuite.getSystemErr(),"The systemerror should be set");
        assertEquals("TestSystemOut",jUnitTestSuite.getSystemOut(),"The systemout should be set");
        assertTrue(jUnitTestSuite.toString().length() > 0);

    }
}
