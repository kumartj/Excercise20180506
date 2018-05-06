package com.ubs.opsit.interviews.berlinclock;

import com.ubs.opsit.interviews.ClockConverter;

public class BerlinClockConverter implements ClockConverter {

    private static final String OFF = "O";
    private static final String YELLOW_LAMP = "Y";
    private static final String RED_LAMP = "R";

    public BerlinClockTime getTime(String time) {
        String[] split = time.split(":");
        return new BerlinClockTime(getSeconds(Integer.parseInt(split[2])),
                getTopFirstRowHour(Integer.parseInt(split[0])),
                getTopSecondRowHour(Integer.parseInt(split[0])),
                getTopFirstRowMinutes(Integer.parseInt(split[1])),
                getBottomSecondRowMinutes(Integer.parseInt(split[1])));
    }

    private String getSeconds(int number) {
        if (number % 2 == 0) {
            return YELLOW_LAMP;
        }
        return OFF;
    }

    private String getTopFirstRowHour(int number) {
        int workingLamps = (number - (number % 5)) / 5;
        return display(4, workingLamps, RED_LAMP);
    }

    private String getTopSecondRowHour(int number) {
        return display(4, number % 5, RED_LAMP);
    }

    private String getTopFirstRowMinutes(int number) {
        int workingLamps = (number - (number % 5)) / 5;
        String displayRow = display(11, workingLamps, YELLOW_LAMP);
        return displayRow.replaceAll("YYY", "YYR");
    }

    private String getBottomSecondRowMinutes(int number) {
        return display(4, number % 5, YELLOW_LAMP);
    }

    private String display(int totalLamps, int workingLamps, String color) {
        StringBuilder display = new StringBuilder();

        for (int i = 0; i < totalLamps; i++) {
            if (workingLamps - i > 0) {
                display.append(color);
            } else {
                display.append(OFF);
            }
        }
        return display.toString();
    }

}
