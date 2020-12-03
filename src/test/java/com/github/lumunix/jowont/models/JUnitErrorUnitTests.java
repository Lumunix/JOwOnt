package com.github.lumunix.jowont.models;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitErrorUnitTests {

    @Test
    public void noArgsConstructor(){
        JUnitError error = new JUnitError();
        assertNull(error.getMessage(),"The message should have been null");
        assertNull(error.getType(),"The type should have been null");
        assertNull(error.getValue(),"The value should have been null");
    }

    @Test
    public void toStringOperation(){
        JUnitError error = new JUnitError();
        error.setMessage("TestMessage");
        error.setType("TestType");
        error.setValue("TestValue");

        assertNotNull(error.toString());
        assertTrue(error.toString().length() > 0);
    }
}
