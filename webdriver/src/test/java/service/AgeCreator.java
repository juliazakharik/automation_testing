package service;

import model.Age;
import model.User;

public class AgeCreator {
    public static final String TESTDATA_AGE = "testdata.age";

    public static Age infoAge(){
        return new Age(Integer.decode(TestDataReader.getTestData(TESTDATA_AGE)));
    }

}
