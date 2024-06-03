package yukwork.calculus.function.rootfinding;

public class BisectionSolver implements RootSolver {

    private final double tolerance;
    private final int maxIterations;

    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(AbstractFunction func, double a, double b) {
        double c = a;
        int iteration = 0;

        if (func.evaluate(a) * func.evaluate(b) >= 0) {
            throw new IllegalStateException("Function values at the interval endpoints must have opposite signs.");
        }

        while ((b - a) >= tolerance) {
            c = (a + b) / 2;
            double fc = func.evaluate(c);
            if (fc == 0.0) {
                break;
            } else if (fc * func.evaluate(a) < 0) {
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
