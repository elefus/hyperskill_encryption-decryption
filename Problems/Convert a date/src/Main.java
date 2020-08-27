import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat to = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

        String originalDate = new Scanner(System.in).nextLine();
        System.out.println(to.format(from.parse(originalDate)));
    }
}