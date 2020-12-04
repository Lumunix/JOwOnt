package com.github.lumunix.jowont.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitFailureUnitTests {
    @Test
    public void noArgsConstructor(){
        JUnitFailure failure = new JUnitFailure();
        assertNull(failure.getMessage(),"The message should have been null");
        assertNull(failure.getType(),"The type should have been null");
        assertNull(failure.getValue(),"The value should have been null");
    }

    @Test
    public void getterAndSetterAndToStringOperation(){
        JUnitFailure failure = new JUnitFailure();
        failure.setMessage("TestMessage");
        failure.setType("TestType");
        failure.setValue("TestValue");
        assertNotNull(failure.toString());
        assertTrue(failure.toString().length() > 0);
    }
}
