package yukwork.calculus.polynomials.integration;

public class SimpsonRule implements Integrator {

    private final double precision;
    private final int maxIterations;

    public SimpsonRule(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    @Override
    public double integrate(Polynomial poly, double lower, double upper) {
        int n = 1;
        double firstIntegration = integrate(poly, lower, upper, n);
        for (int i = 0; i < maxIterations; i++) {
            double secondIntegration = integrate(poly, lower, upper, n * 2);
            if (Math.abs(secondIntegration - firstIntegration) / 3 < precision) {
                return secondIntegration;
            }
            firstIntegration = secondIntegration;
            n *= 2;
        }
        return firstIntegration;
    }

    private double integrate(Polynomial poly, double lower, double upper, int numOfSubIntervals) {
        double deltaX = (upper - lower) / numOfSubIntervals;
        double sum = poly.evaluate(lower) + poly.evaluate(upper);

        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * deltaX;
            if (i % 2 == 0) {
                sum += 2 * poly.evaluate(x);
            } else {
                sum += 4 * poly.evaluate(x);
            }
        }
        return sum * deltaX / 3;
    }

}
