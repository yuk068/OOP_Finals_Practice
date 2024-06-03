package yukwork.calculus.polynomials.rootfinding;

public class PolynomialRootFinding {

    private Polynomial poly;
    private RootSolver rootSolver;

    public PolynomialRootFinding(Polynomial polynomial) {
        poly = polynomial;
    }

    public PolynomialRootFinding(Polynomial polynomial, RootSolver rootSolver) {
        poly = polynomial;
        this.rootSolver = rootSolver;
    }

    public void setPoly(Polynomial poly) {
        this.poly = poly;
    }

    public void setRootSolver(RootSolver rootSolver) {
        this.rootSolver = rootSolver;
    }

    public double solve(double lower, double upper) {
        return rootSolver.solve(poly, lower, upper);
    }

}
