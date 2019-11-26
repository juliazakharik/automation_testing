package service;

import java.util.ResourceBundle;

public class DataReader {
    private static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getData(String key) {
        return resourceBundle.getString(key);
    }
}
