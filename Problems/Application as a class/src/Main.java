import java.util.stream.Stream;

class Application {

    String name;

    void run(String[] args) {
        System.out.println(name);
        Stream.of(args).forEach(System.out::println);
    }
}