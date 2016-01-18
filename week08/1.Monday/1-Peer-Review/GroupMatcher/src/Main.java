import org.hackbulgaria.Matcher;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Matcher groupMatcher = new Matcher("people.txt", 5);
            groupMatcher.printRotations();
        } catch (IOException ioe) {
            System.err.println("Error while reading people list.");
            ioe.printStackTrace();
        }
    }
}
