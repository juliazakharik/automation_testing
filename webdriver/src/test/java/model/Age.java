package model;

import java.util.Objects;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Age {
    private int age;
    private static final Logger LOGGER = null;

    public Age(int age) {
        this.age = age;
        LOGGER.info("Age object initialised");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Age)) return false;
        Age age1 = (Age) o;
        return getAge() == age1.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge());
    }


    @Override
    public String toString() {
        return "Age{" +
                "age=" + age +
                '}';
    }
}
