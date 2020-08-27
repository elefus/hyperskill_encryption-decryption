import java.util.Scanner;
import java.util.regex.Pattern;

import static java.util.Comparator.comparingInt;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String result = Pattern.compile(" ")
                               .splitAsStream(in.nextLine())
                               .max(comparingInt(String::length))
                               .orElse("");

        System.out.println(result);
    }
}