import org.hackbulgaria.Matcher;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Matcher groupMatcher = new Matcher("people.txt", 5);
        groupMatcher.getRotation();
    }
}
