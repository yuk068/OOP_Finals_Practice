package yukwork.calculus.polynomials.rootfinding;

public class NewtonRaphsonSolver implements RootSolver {

    private final double tolerance;
    private final int maxIterations;

    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        double x0 = (lower + upper) / 2;

        for (int i = 0; i < maxIterations; i++) {
            double fx = polynomial.evaluate(x0);
            double dfx = polynomial.derivative().evaluate(x0);

            double x1 = x0 - fx / dfx;

            if (Math.abs(x1 - x0) < tolerance) {
                return x1;
            }

            x0 = x1;
        }

        return Double.NaN;
    }

}
