package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Time {
    private String startTime;
    private String endTime;
    private static final Logger LOGGER = LogManager.getRootLogger();

    public Time(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        LOGGER.info("Time inilialized");
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;
        Time time = (Time) o;
        return Objects.equals(getStartTime(), time.getStartTime()) &&
                Objects.equals(getEndTime(), time.getEndTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartTime(), getEndTime());
    }

    @Override
    public String toString() {
        return "Time{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
