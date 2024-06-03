package yukwork.calculus.function.rootfindingapp;

import java.util.function.Function;

public class RootFinder {

    private RootFindingStrategy strategy;

    public void setStrategy(RootFindingStrategy strategy) {
        this.strategy = strategy;
    }

    public double findRoot(Function<Double, Double> func, double a, double b, double tol) {
        return strategy.findRoot(func, a, b, tol);
    }

}

