package yukwork.calculus.function.rootfindingapp;

import java.util.function.Function;

public class BisectionMethod implements RootFindingStrategy {

    @Override
    public double findRoot(Function<Double, Double> func, double a, double b, double tol) {
        double c = a;
        int maxIterations = 1000;
        int iteration = 0;

        if (func.apply(a) * func.apply(b) >= 0) {
            throw new IllegalStateException("Function values at the interval endpoints must have opposite signs.");
        }

        while ((b - a) >= tol) {
            c = (a + b) / 2;
            double fc = func.apply(c);
            if (fc == 0.0) {
                break;
            } else if (fc * func.apply(a) < 0) {
                b = c;
            } else {
                a = c;
            }

            iteration++;
            if (iteration > maxIterations) {
                throw new IllegalStateException("Maximum number of iterations reached. No solution found.");
            }
        }

        return c;
    }

}

