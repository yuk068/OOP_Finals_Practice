package yukwork.calculus.function.intergration;

public abstract class AbstractIntegrator implements Integrator {

    protected double precision;
    protected int maxIterations;

    public AbstractIntegrator(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

}
