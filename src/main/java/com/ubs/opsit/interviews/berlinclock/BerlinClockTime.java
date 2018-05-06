package com.ubs.opsit.interviews.berlinclock;

import com.ubs.opsit.interviews.ClockTime;

import java.util.Objects;

public class BerlinClockTime implements ClockTime {

    private final String topRowHour;
    private final String bottomRowHour;
    private final String topRowMinute;
    private final String bottomRowMinute;
    private final String seconds;

    public BerlinClockTime(String seconds, String topRowHour, String bottomRowHour, String topRowMinute, String bottomRowMinute) {
        this.seconds = seconds;
        this.topRowHour = topRowHour;
        this.bottomRowHour = bottomRowHour;
        this.topRowMinute = topRowMinute;
        this.bottomRowMinute = bottomRowMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BerlinClockTime that = (BerlinClockTime) o;
        return Objects.equals(seconds, that.seconds) &&
                Objects.equals(topRowHour, that.topRowHour) &&
                Objects.equals(bottomRowHour, that.bottomRowHour) &&
                Objects.equals(topRowMinute, that.topRowMinute) &&
                Objects.equals(bottomRowMinute, that.bottomRowMinute);
    }

    @Override
    public int hashCode() {

        return Objects.hash(seconds, topRowHour, bottomRowHour, topRowMinute, bottomRowMinute);
    }

    @Override
    public String toString() {
        return seconds + '\n' +
                topRowHour + '\n' +
                bottomRowHour + '\n' +
                topRowMinute + '\n' +
                bottomRowMinute + '\n';

    }

    @Override
    public String getTime() {
        return seconds + "\r" + '\n' +
                topRowHour + "\r" + '\n' +
                bottomRowHour + "\r" + '\n' +
                topRowMinute + "\r" + '\n' +
                bottomRowMinute;
    }
}
