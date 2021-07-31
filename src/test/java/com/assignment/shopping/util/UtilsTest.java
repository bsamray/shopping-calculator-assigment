package com.assignment.shopping.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {

    @Test
    public void testReturnsNoDecimalWhenRounded() {
        assertEquals("10", Utils.formatDoubleForDisplay(Double.valueOf(10.0)));
    }

    @Test
    public void testReturnsDecimalWhenNotRounded() {
        assertEquals("10.2", Utils.formatDoubleForDisplay(Double.valueOf(10.2)));
    }
}
