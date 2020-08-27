import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/* Product - Clock */
interface Clock {
    void tick();
}

/* Concrete Product - Sand Clock */
class SandClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...sand noise...");
    }
}

/* Concrete Product - Digital Clock */
class DigitalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...pim...");
    }
}

/* Concrete Product - Mechanical Clock */
class MechanicalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...clang mechanism...");
    }
}

abstract class AbstractClockFactory {

    protected abstract Clock create();
}

class SandClockFactory extends AbstractClockFactory {

    @Override
    protected SandClock create() {
        return new SandClock();
    }
}

class DigitalClockFactory extends AbstractClockFactory {

    @Override
    protected DigitalClock create() {
        return new DigitalClock();
    }
}

class MechanicalClockFactory extends AbstractClockFactory {

    @Override
    protected MechanicalClock create() {
        return new MechanicalClock();
    }
}

class ClockFactory {

    private final Map<String, AbstractClockFactory> factories = Map.of(
        "Sand", new SandClockFactory(),
        "Digital", new DigitalClockFactory(),
        "Mechanical", new MechanicalClockFactory()
    );

    /* It produces concrete clocks corresponding their types : Digital, Sand or Mechanical */
    public Clock produce(String type) {
        return Optional.ofNullable(factories.get(type))
                       .orElseThrow(() -> new IllegalArgumentException("Unknown type of Clock required!"))
                       .create();
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.next();
        final ClockFactory clockFactory = new ClockFactory();
        final Clock clock = clockFactory.produce(type);
        clock.tick();
        scanner.close();
    }
}