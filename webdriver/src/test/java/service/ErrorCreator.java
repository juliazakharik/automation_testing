package service;

import model.Error;

public class ErrorCreator {
    private static final String EMPTY_FIELDS_ERROR =
            "testdata.empty.fields.error";
    private static final String AGE_ERROR =
            "testdata.rent.error";

    public static Error rentErrorWithInfoFromProperty() {
        return new Error(TestDataReader.getTestData(AGE_ERROR));
    }

    public static Error emptyErrorWithInfoFromPropety() {
        return new Error(TestDataReader.getTestData(EMPTY_FIELDS_ERROR));
    }
}
