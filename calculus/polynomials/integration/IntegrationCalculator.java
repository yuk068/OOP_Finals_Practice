package yukwork.calculus.polynomials.integration;

public class IntegrationCalculator {

    private Integrator integrator;
    private Polynomial poly;

    public IntegrationCalculator(Polynomial poly) {
        this.poly = poly;
    }

    public IntegrationCalculator(Integrator integrator, Polynomial poly) {
        this.integrator = integrator;
        this.poly = poly;
    }

    public void setPoly(Polynomial poly) {
        this.poly = poly;
    }

    public void setIntegrator(Integrator integrator) {
        this.integrator = integrator;
    }

    public double integrate(double lower, double upper) {
        return integrator.integrate(poly, lower, upper);
    }

}
