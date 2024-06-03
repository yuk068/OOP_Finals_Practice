package yukwork.calculus.function.rootfinding;

public class UnivariateRealRootFinding {

    private AbstractFunction function;
    private RootSolver rootSolver;

    public UnivariateRealRootFinding(AbstractFunction function) {
        this.function = function;
    }

    public UnivariateRealRootFinding(AbstractFunction function, RootSolver rootSolver) {
        this.function = function;
        this.rootSolver = rootSolver;
    }

    public void setFunction(AbstractFunction function) {
        this.function = function;
    }

    public void setRootSolver(RootSolver rootSolver) {
        this.rootSolver = rootSolver;
    }

    public double solve(double lower, double upper) {
        return rootSolver.solve(function, lower, upper);
    }

}
