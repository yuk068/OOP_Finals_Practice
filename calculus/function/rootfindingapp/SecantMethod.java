package yukwork.calculus.function.rootfindingapp;

import java.util.function.Function;

public class SecantMethod implements RootFindingStrategy {

    @Override
    public double findRoot(Function<Double, Double> func, double x0, double x1, double tol) {
        double x2;
        int maxIterations = 1000;
        int iteration = 0;

        while (Math.abs(x1 - x0) >= tol) {
            double f0 = func.apply(x0);
            double f1 = func.apply(x1);

            if (f1 == f0) {
                throw new IllegalStateException("Division by zero encountered in the Secant method.");
            }

            x2 = x1 - (f1 * (x1 - x0)) / (f1 - f0);
            x0 = x1;
            x1 = x2;

            iteration++;
            if (iteration > maxIterations) {
                throw new IllegalStateException("Maximum number of iterations reached. No solution found.");
            }
        }

        return x1;
    }

}

