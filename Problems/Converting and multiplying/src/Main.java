import java.io.File;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        File file = new File("image/1.png");
        System.out.println(file.getPath());

        File parent = new File(file.isFile());
        System.out.println(parent.getPath());

        System.out.println(new File(parent.getParent()).getPath());


//        Scanner in = new Scanner(System.in);
//
//        for (String line = in.nextLine(); !"0".equals(line); line = in.nextLine()) {
//            try {
//                System.out.println(Integer.parseInt(line) * 10);
//            } catch (NumberFormatException ex) {
//                System.out.println("Invalid user input: " + line);
//            }
//        }
    }
}
