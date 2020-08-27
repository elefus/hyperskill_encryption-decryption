import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int shift = in.nextInt();

        if (shift < str.length()) {
            str = str.substring(shift) + str.substring(0, shift);
        }

        System.out.println(str);
    }
}