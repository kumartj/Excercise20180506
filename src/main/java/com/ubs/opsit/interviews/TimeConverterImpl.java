package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.berlinclock.BerlinClockConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConverterImpl implements TimeConverter {

    private final ClockConverter clockConverter;
    private static final String TIME12HOURS_PATTERN = "([01]?[0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]";
    private static final Pattern pattern = Pattern.compile(TIME12HOURS_PATTERN);

    public TimeConverterImpl() {
        this.clockConverter = new BerlinClockConverter();
    }

    @Override
    public String convertTime(String aTime) {
        validate(aTime);
        ClockTime clock = clockConverter.getTime(aTime);
        return clock.getTime();
    }

    private void validate(String aTime) {
        Matcher matcher = pattern.matcher(aTime);
        if(!matcher.matches()){
            throw  new RuntimeException("Illegal argument exception");
        }

    }


}
