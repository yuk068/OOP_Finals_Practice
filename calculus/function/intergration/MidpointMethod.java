package yukwork.calculus.function.intergration;

public class MidpointMethod extends AbstractIntegrator {

    public MidpointMethod(double precision, int maxIterations) {
        super(precision, maxIterations);
    }

    @Override
    public double integrate(AbstractFunction func, double lower, double upper) {
        int n = 1;
        double firstIntegration = integrate(func, lower, upper, n);
        for (int i = 0; i < maxIterations; i++) {
            double secondIntegration = integrate(func, lower, upper, n * 2);
            if (Math.abs(secondIntegration - firstIntegration) / 3 < precision) {
                return secondIntegration;
            }
            firstIntegration = secondIntegration;
            n *= 2;
        }
        return firstIntegration;
    }

    private double integrate(AbstractFunction func, double lower, double upper, int numOfSubIntervals) {
        double step = (upper - lower) / numOfSubIntervals;
        double sum = 0.0;
        for (int i = 0; i < numOfSubIntervals; i++) {
            double midpoint = lower + (i + 0.5) * step;
            sum += func.evaluate(midpoint);
        }
        return sum * step;
    }

}
