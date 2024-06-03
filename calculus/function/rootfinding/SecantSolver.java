package yukwork.calculus.function.rootfinding;

public class SecantSolver implements RootSolver {

    private final double tolerance;
    private final int maxIterations;

    public SecantSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        double x0 = lower;
        double x1 = upper;
        double f0 = function.evaluate(x0);
        double f1 = function.evaluate(x1);

        for (int i = 0; i < maxIterations; i++) {
            if (Math.abs(f1 - f0) < tolerance) {
                throw new ArithmeticException("Function values at the points are too close to each other.");
            }

            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            if (Math.abs(x2 - x1) < tolerance) {
                return x2;
            }

            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = function.evaluate(x1);
        }

        throw new ArithmeticException("Maximum number of iterations exceeded.");
    }

}