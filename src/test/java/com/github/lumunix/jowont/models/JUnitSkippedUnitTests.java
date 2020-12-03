package com.github.lumunix.jowont.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitSkippedUnitTests {
    @Test
    public void toStringOperation(){
        JUnitSkipped skipped = new JUnitSkipped();
        assertTrue(skipped.toString().length() > 0);
    }
}
