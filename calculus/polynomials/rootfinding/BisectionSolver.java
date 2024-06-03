package yukwork.calculus.polynomials.rootfinding;

public class BisectionSolver implements RootSolver {

    private final double tolerance;
    private final int maxIterations;

    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        if (polynomial.evaluate(lower) * polynomial.evaluate(upper) >= 0) return Double.NaN;
        double mid = lower;
        int iteration = 0;
        while ((upper - lower) >= tolerance && iteration < maxIterations) {
            mid = (lower + upper) / 2;
            if (polynomial.evaluate(mid) == 0) break;
            else if (polynomial.evaluate(mid) * polynomial.evaluate(lower) < 0) upper = mid;
            else lower = mid;
            iteration++;
        }
        return mid;
    }

}
