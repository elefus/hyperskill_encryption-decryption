import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int len = str.length();
        System.out.println(str.substring(0, len / 2 - (len + 1) % 2) + str.substring(len / 2 + 1));
    }
}