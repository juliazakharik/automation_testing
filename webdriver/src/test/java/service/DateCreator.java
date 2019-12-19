package service;

import model.Date;

public class DateCreator {
    public static final String START_DATE = "testdata.start";
    public static final String END_DATE = "testdata.end";

    public static Date infoDate() {
        return new Date(TestDataReader.getTestData(START_DATE),
                TestDataReader.getTestData(END_DATE));
    }
}
