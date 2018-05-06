package com.ubs.opsit.interviews.berlinclock;

import org.junit.Test;

import static org.junit.Assert.*;

public class BerlinClockConverterTest {

    @Test
    public void getTime() {
        //give
        String inputTime = "00:00:00";
        BerlinClockTime expected = new BerlinClockTime("Y","OOOO","OOOO","OOOOOOOOOOO","OOOO");
        //when
        BerlinClockConverter testClass = new BerlinClockConverter();

        BerlinClockTime result = testClass.getTime(inputTime);

        assertEquals(expected, result);
    }
}