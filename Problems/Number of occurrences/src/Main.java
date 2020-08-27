import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String substr = in.nextLine();

        int result = 0;
        int searchingIndex = 0;
        int foundIndex;
        do {
            foundIndex = str.indexOf(substr, searchingIndex);
            if (foundIndex >= 0) {
                ++result;
                searchingIndex = foundIndex + substr.length();
            }
        } while (foundIndex >= 0);

        System.out.println(result);
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Pattern x = Pattern.compile(in.nextLine());

        Matcher countMatcher = x.matcher(str);
        System.out.println(countMatcher.results().count());
    }
}