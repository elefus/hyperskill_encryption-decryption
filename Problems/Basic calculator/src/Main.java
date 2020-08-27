import java.util.Map;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int leftOperand = Integer.parseInt(args[1]);
        int rightOperand = Integer.parseInt(args[2]);

        Map<String, IntBinaryOperator> operators = Map.of(
                "+", Math::addExact,
                "-", Math::subtractExact,
                "*", Math::multiplyExact
        );

        Optional.ofNullable(operators.get(operator))
                .map(op -> op.applyAsInt(leftOperand, rightOperand))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Unknown operator"));
    }
}