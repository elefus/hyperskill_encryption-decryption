import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/* Product - Motor */
class Motor {

    String model;
    long power;

    public Motor(String model, long power) {
        this.model = model;
        this.power = power;
    }

    @Override
    public String toString() {
        return "motor={model:" + model + ",power:" + power + "}";
    }
}

class PneumaticMotor extends Motor {

    public PneumaticMotor(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {
        return "Pneumatic " + super.toString();
    }
}

class HydraulicMotor extends Motor {

    public HydraulicMotor(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {
        return "Hydraulic " + super.toString();
    }
}

class ElectricMotor extends Motor {

    public ElectricMotor(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {
        return "Electric " + super.toString();
    }
}

class WarpDrive extends Motor {

    public WarpDrive(String model, long power) {
        super(model, power);
    }

}

interface MotorFactory {

    Motor make(String model, long power);
}

public class Main {

    private static final Map<Character, MotorFactory> MOTOR_FACTORIES = Map.of(
        'P', PneumaticMotor::new,
        'H', HydraulicMotor::new,
        'E', ElectricMotor::new,
        'W', WarpDrive::new
    );

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            char type = Character.toUpperCase(scanner.next().charAt(0));
            String model = scanner.next();
            long power = scanner.nextLong();

            Motor motor = Optional.ofNullable(MOTOR_FACTORIES.get(type))
                                  .orElseThrow(() -> new IllegalArgumentException("Unknown type of motor is required!"))
                                  .make(model, power);
            System.out.println(motor);
        }
    }
}