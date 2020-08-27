import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Generator[] generators = {new Generator('A', 'Z'), new Generator('a', 'z'), new Generator('0', '9')};
        Supplier<Generator> getRndGenerator = () -> generators[ThreadLocalRandom.current().nextInt(generators.length)];

        List<Generator> result = new ArrayList<>();
        Stream.generate(() -> generators[0]).limit(in.nextInt()).forEach(result::add);
        Stream.generate(() -> generators[1]).limit(in.nextInt()).forEach(result::add);
        Stream.generate(() -> generators[2]).limit(in.nextInt()).forEach(result::add);
        Stream.generate(getRndGenerator).limit(in.nextInt() - result.size()).forEach(result::add);

        Collections.shuffle(result);

        System.out.println(result.stream().map(Generator::next).map(String::valueOf).collect(joining()));
    }
}

class Generator {

    private final char fromInclusive;
    private final char toInclusive;
    private char prev;

    public Generator(char fromInclusive, char toInclusive) {
        this.fromInclusive = fromInclusive;
        this.toInclusive = toInclusive;
    }

    public char next() {
        char next;
        do {
            next = (char) ThreadLocalRandom.current().nextInt(fromInclusive, toInclusive + 1);
        } while (next == prev);
        prev = next;
        return next;
    }
}