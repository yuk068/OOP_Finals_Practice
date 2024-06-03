package yukwork.calculus.function.intergration;

public class IntegrationCalculator {

    private Integrator integrator;
    private AbstractFunction function;

    public IntegrationCalculator(AbstractFunction polynomial) {
        this.function = polynomial;
    }

    public IntegrationCalculator(Integrator integrator, AbstractFunction function) {
        this.integrator = integrator;
        this.function = function;
    }

    public void setIntegrator(Integrator integrator) {
        this.integrator = integrator;
    }

    public void setFunction(AbstractFunction function) {
        this.function = function;
    }

    public double integrate(double lower, double upper) {
        return integrator.integrate(function, lower, upper);
    }

}
