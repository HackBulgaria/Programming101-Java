package org.hackbulgaria;

/**
 * Created by plamen on 1/18/16.
 */
public class Person {
    private final String mFirstName;
    private final String mLastName;

    public Person(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", mFirstName, mLastName);
    }
}
