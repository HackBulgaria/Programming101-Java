package org.hackbulgaria;

/**
 * Created by plamen on 1/18/16.
 */
public class Pair {
    private final Person mPersonA;
    private final Person mPersonB;

    public Pair(Person personA, Person personB) {
        mPersonA = personA;
        mPersonB = personB;
    }

    @Override
    public String toString() {
        return String.format("* Pair(%s, %s)", mPersonA, mPersonB);
    }
}
