import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

class Problem {

    public static void main(String[] args) {
        Map<String, Function<IntStream, Integer>> operators = Map.of(
                "MAX", intStream -> intStream.max().orElseThrow(),
                "MIN", intStream -> intStream.min().orElseThrow(),
                "SUM", IntStream::sum
        );

        String operator = args[0];

        IntStream values = Arrays.asList(args).subList(1, args.length).stream().mapToInt(Integer::parseInt);
        System.out.println(operators.get(operator).apply(values));
    }
}