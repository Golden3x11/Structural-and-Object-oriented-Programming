package Operations;

public class Operations {
    public static String summing(double x, double y) {
        return String.valueOf(x + y);
    }

    public static String subtracting(double x, double y) {
        return String.valueOf(x - y);
    }

    public static String multiplying(double x, double y) {
        return String.valueOf(x * y);
    }

    public static String dividing(double x, double y) {
        try {
            double result = x / y;
            if (y == 0) throw new MojWyjatek("");
            return String.valueOf(result);
        } catch (MojWyjatek e) {
            return "Nie dzielimy przez 0";
        }
    }

    static class MojWyjatek extends Exception {
        public MojWyjatek(String s) {
            super(s);
        }

    }
}
