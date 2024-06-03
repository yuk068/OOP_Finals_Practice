package yukwork.calculus.function.rootfinding;

public class NewtonRaphsonSolver implements RootSolver {

    private final double tolerance;
    private final int maxIterations;

    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        double x0 = (lower + upper) / 2;

        for (int i = 0; i < maxIterations; i++) {
            double fx = function.evaluate(x0);
            double fpx = function.derivative(x0);

            if (Math.abs(fpx) < tolerance) {
                throw new ArithmeticException("Derivative is too small.");
            }

            double x1 = x0 - fx / fpx;

            if (Math.abs(x1 - x0) < tolerance) {
                return x1;
            }

            x0 = x1;
        }

        throw new ArithmeticException("Maximum number of iterations exceeded.");
    }

}
