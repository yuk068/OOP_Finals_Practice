package yukwork.calculus.function.intergration;

public class SimpsonMethod extends AbstractIntegrator {

    public SimpsonMethod(double precision, int maxIterations) {
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
        double deltaX = (upper - lower) / numOfSubIntervals;
        double sum = func.evaluate(lower) + func.evaluate(upper);

        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * deltaX;
            if (i % 2 == 0) {
                sum += 2 * func.evaluate(x);
            } else {
                sum += 4 * func.evaluate(x);
            }
        }
        return sum * deltaX / 3;
    }

}
