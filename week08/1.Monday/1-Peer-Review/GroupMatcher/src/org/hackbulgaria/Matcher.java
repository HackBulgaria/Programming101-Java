package org.hackbulgaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Matcher {
    private final int mRotations;
    private final Path mPeoplePath;
    private List<Person> mPeople;
    private Set<Integer> mPairedPeople;

    public Matcher(String peoplePath, int rotations) throws IOException {
        mPeoplePath = Paths.get(peoplePath);
        mRotations = rotations;
        mPeople = getPeople();
        mPairedPeople = new HashSet<>();
    }

    private List<Person> getPeople() throws IOException {
        List<Person> people = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(mPeoplePath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] args = line.split("\\s+");
                Person newPerson = new Person(args[0], args[1]);
                people.add(newPerson);
            }
        }

        return people;
    }

    private int getPersonIndex() {
        Random random = new Random();

        int index;
        do {
            index = random.nextInt(mPeople.size());
        } while (mPairedPeople.contains(index));
        mPairedPeople.add(index);

        return index;
    }

    public void getRotation() {
        List<Pair> pairs = new ArrayList<>();
        while (mPairedPeople.size() < mPeople.size()) {
            Person personA = mPeople.get(getPersonIndex());
            Person personB = mPeople.get(getPersonIndex());

            Pair newPair = new Pair(personA, personB);
            pairs.add(newPair);
        }
        for (Pair pair : pairs) {
            System.out.println(pair);
        }

        mPairedPeople = new HashSet<>();
    }

    public void printRotations() {
        for (int i = 0; i < mRotations; i++) {
            System.out.printf("## Rotation %s%n%n", i + 1);
            getRotation();
            System.out.println();
        }
    }
}
