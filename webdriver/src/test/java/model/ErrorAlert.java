package model;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ErrorAlert {
    private String errorDescription;
    private static final Logger LOGGER = LogManager.getRootLogger();

    public ErrorAlert(String errorDescription) {
        this.errorDescription = errorDescription;
        LOGGER.info("Error initialised");
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorAlert)) return false;
        ErrorAlert error = (ErrorAlert) o;
        return Objects.equals(getErrorDescription(), error.getErrorDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getErrorDescription());
    }

    @Override
    public String toString() {
        return "Error{" +
                "errorDescription='" + errorDescription + '\'' +
                '}';
    }
}
