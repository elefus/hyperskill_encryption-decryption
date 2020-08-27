import java.util.stream.IntStream;

class Army {

    public static void createArmy() {
        IntStream.range(0, 5).mapToObj(String::valueOf).forEach(Unit::new);
        IntStream.range(0, 3).mapToObj(String::valueOf).forEach(Knight::new);
        IntStream.range(0, 1).mapToObj(String::valueOf).forEach(General::new);
        IntStream.range(0, 1).mapToObj(String::valueOf).forEach(Doctor::new);
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}