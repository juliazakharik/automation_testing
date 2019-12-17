package model;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Date {
    private Date startDate;
    private Date endDate;
    private static final Logger LOGGER = LogManager.getRootLogger();

    public Date(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        LOGGER.info("Date initialised");
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
