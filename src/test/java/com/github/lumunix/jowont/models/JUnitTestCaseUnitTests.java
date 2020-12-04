package com.github.lumunix.jowont.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitTestCaseUnitTests {
    @Test
    public void noArgsConstructor(){
        JUnitTestCase testcase = new JUnitTestCase();
        assertNull(testcase.getClassName(),"The classname should have been null");
        assertNull(testcase.getErrors(),"The errors should have been null");
        assertNull(testcase.getFailures(),"The failures should have been null");
        assertNull(testcase.getName(),"The name should have been null");
        assertNull(testcase.getSkipped(),"The skipped should have been null");
        assertNull(testcase.getSystemErr(),"The systemerr should have been null");
        assertNull(testcase.getSystemOut(),"The systemout should have been null");
        assertNull(testcase.getTime(), "The time should have been zero");
    }

    @Test
    public void getterAndSetterAndToStringOperation(){
        JUnitTestCase testcase = new JUnitTestCase();
        testcase.setClassName("TestClassname");
        testcase.setErrors(new ArrayList<>());
        testcase.setFailures(new ArrayList<>());
        testcase.setName("TestName");
        testcase.setSkipped(new JUnitSkipped());
        testcase.setSystemErr("TestSystemError");
        testcase.setSystemOut("TestSystemOut");
        testcase.setTime(3.0);

        assertEquals("TestClassname",testcase.getClassName(),"The classname should have set");
        assertNotNull(testcase.getErrors(),"The errors should have initialized");
        assertNotNull(testcase.getFailures(),"The failures should have been initialized");
        assertEquals("TestName",testcase.getName(),"The name should have been set");
        assertNotNull(testcase.getSkipped(),"Expected the skipped object");
        assertEquals("TestSystemError",testcase.getSystemErr(),"The TestSystemOut should have been set");
        assertEquals("TestSystemOut",testcase.getSystemOut(),"The TestSystemOut should have been set");
        assertEquals(3.0,testcase.getTime(),"The Time should have been set");
        assertTrue(testcase.toString().length() > 0);
    }
}
