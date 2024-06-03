package yukwork.calculus.function.rootfindingapp;

import java.util.function.Function;

public interface RootFindingStrategy {

    double findRoot(Function<Double, Double> func, double a, double b, double tol);

}

