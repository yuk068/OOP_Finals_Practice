package yukwork.calculus.function.rootfindingapp;

import java.util.function.Function;

public class NewtonRaphsonMethod implements RootFindingStrategy {

    private static final double EPSILON = 1e-8;

    @Override
    public double findRoot(Function<Double, Double> func, double x0, double b, double tol) throws IllegalStateException {
        double x = x0;
        int maxIterations = 1000;
        int iteration = 0;

        while (Math.abs(func.apply(x)) > tol) {
            double derivative = (func.apply(x + EPSILON) - func.apply(x)) / EPSILON;

            if (Math.abs(derivative) < EPSILON) {
                throw new IllegalStateException("Derivative is too close to zero. No solution found.");
            }

            x = x - func.apply(x) / derivative;

            iteration++;
            if (iteration > maxIterations) {
                throw new IllegalStateException("Maximum number of iterations reached. No solution found.");
            }
        }
        return x;
    }

}


