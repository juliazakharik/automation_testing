package model;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Date {
    private String startDate;
    private String endDate;
    private static final Logger LOGGER = LogManager.getRootLogger();

    public Date(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        LOGGER.info("Date initialised");
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;
        Date date = (Date) o;
        return Objects.equals(getStartDate(), date.getStartDate()) &&
                Objects.equals(getEndDate(), date.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartDate(), getEndDate());
    }

    @Override
    public String toString() {
        return "Date{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
