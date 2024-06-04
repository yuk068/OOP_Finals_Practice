package yukwork.calculus.function.rootfinding;

public class MyMath {

    private static final int TERMS = 20;

    public static double sin(double x) {
        double result = 0.0;
        for (int n = 0; n < TERMS; n++) {
            result += Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
        }
        return result;
    }

    public static double cos(double x) {
        double result = 0.0;
        for (int n = 0; n < TERMS; n++) {
            result += Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
        }
        return result;
    }

    public static double tan(double x) {
        return sin(x) / cos(x);
    }

    public static double exp(double x) {
        double result = 0.0;
        for (int n = 0; n < TERMS; n++) {
            result += Math.pow(x, n) / factorial(n);
        }
        return result;
    }

    public static double ln(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Input must be greater than 0");
        }
        if (x == 1) {
            return 0;
        }
        double y = (x - 1) / (x + 1);
        double result = 0.0;
        for (int n = 0; n < TERMS; n++) {
            result += 2 * Math.pow(y, 2 * n + 1) / (2 * n + 1);
        }
        return result;
    }

    public static double ln1p(double x) {
        if (x <= -1) {
            throw new IllegalArgumentException("Input must be greater than -1");
        }
        if (x >= 1) return Math.log1p(x);
        double result = 0.0;
        for (int n = 1; n <= TERMS; n++) {
            result += Math.pow(-1, n + 1) * Math.pow(x, n) / n;
        }
        return result;
    }

    public static double log(double x, int a) {
        return ln(x) / ln(a);
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Input must be greater than or equal to 0");
        }
        if (x == 0) {
            return 0;
        }

        double guess = x / 2;
        double prevGuess;

        do {
            prevGuess = guess;
            guess = 0.5 * (guess + x / guess);
        } while (Math.abs(guess - prevGuess) >= 1e-10);

        return guess;
    }

    public static double factorial(int n) {
        double result = 1.0;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}

