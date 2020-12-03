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
    public void toStringOperation(){
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
        assertNotNull(testcase.getFailures(),"The failures should have failures");
        assertEquals("TestName",testcase.getName(),"The name should have set");


        assertNull(testcase.getErrors(),"The errors should have been null");
        assertNull(testcase.getFailures(),"The failures should have been null");
        assertNull(testcase.getName(),"The name should have been null");
        assertNull(testcase.getSkipped(),"The skipped should have been null");
        assertNull(testcase.getSystemErr(),"The systemerr should have been null");
        assertNull(testcase.getSystemOut(),"The systemout should have been null");
        assertNull(testcase.getTime(), "The time should have been zero");

        /*
        testcase.setAssertions(1)
        testcase.setName("TestName");
        testcase.setValue("TestValue");
        assertNotNull(property.toString());
        assertTrue(property.toString().length() > 0);

         */
    }
}
