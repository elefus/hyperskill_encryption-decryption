import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Main {

    public static String prepareFullName(String firstName, String lastName) {
        return Stream.of(firstName, lastName)
                     .filter(Objects::nonNull)
                     .collect(joining(" "));
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        firstName = "null".equals(firstName) ? null : firstName;

        String lastName = scanner.nextLine();
        lastName = "null".equals(lastName) ? null : lastName;

        System.out.println(prepareFullName(firstName, lastName));
    }
}