package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeConverterImplTest {

    @Test
    public void convertTime() {

        //given
        String time = "24:00:00";
        String expected = "Y\r\n" +
                "RRRR\r\n" +
                "RRRR\r\n" +
                "OOOOOOOOOOO\r\n" +
                "OOOO";
        //when
        TimeConverter testClass = new TimeConverterImpl();

        String result = testClass.convertTime(time);

        assertEquals(expected, result);
    }

    @Test
    public void validateTime_invalidTime(){
        //given
        String time = "03:70:10";

        //when
        TimeConverter testClass = new TimeConverterImpl();

        try {
            testClass.convertTime(time);
            Assert.fail("Expected exception has to be thrown");
        }catch (Exception e){
            assertEquals("Illegal argument exception", e.getMessage());
        }

    }

    @Test
    public void validateTime_Time(){
        //given
        String time = "03:59:10";

        //when
        TimeConverter testClass = new TimeConverterImpl();

        try {
            testClass.convertTime(time);
        }catch (Exception e){
            Assert.fail("No exception to be thrown");
        }

    }
}