package com.github.lumunix.jowont.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitPropertyUnitTests {

    @Test
    public void noArgsConstructor(){
        JUnitProperty property = new JUnitProperty();
        assertNull(property.getName(),"The name should have been null");
        assertNull(property.getValue(),"The value should have been null");
    }

    @Test
    public void getterAndSetterAndToStringOperation(){
        JUnitProperty property = new JUnitProperty();
        property.setName("TestName");
        property.setValue("TestValue");
        assertNotNull(property.toString());
        assertTrue(property.toString().length() > 0);
    }
}

