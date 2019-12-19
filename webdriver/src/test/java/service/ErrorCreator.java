package service;

import model.ErrorAlert;

public class ErrorCreator {
    private static final String EMPTY_FIELDS_ERROR =
            "testdata.empty.fields.error";
    private static final String AGE_ERROR =
            "testdata.rent.error";


    public static ErrorAlert rentError() {
        return new ErrorAlert(TestDataReader.getTestData(AGE_ERROR));
    }

    public static ErrorAlert emptyError() {
        return new ErrorAlert(TestDataReader.getTestData(EMPTY_FIELDS_ERROR));
    }

    public static ErrorAlert ageError() {
        return new ErrorAlert(TestDataReader.getTestData(AGE_ERROR));
    }
}
