package yukwork.calculus.function.rootfinding;

public class RootFindingTestDrive {

    public static void main(String[] args) {
        testRootSolver();
    }

    public static void testRootSolver() {
        AbstractFunction function = new SinXtimesXplusThree();

        double tolerance = 1e-12;
        int maxIterations = 1000;
        double lowerBound = 0;
        double upperBound = 5;
        boolean calculationFailed = false;

        UnivariateRealRootFinding solver = new UnivariateRealRootFinding(function);
        solver.setRootSolver(new BisectionSolver(tolerance, maxIterations));
        try {
            double rootBisection = solver.solve(lowerBound, upperBound);
            System.out.println("Bisection method root: " + rootBisection);
        } catch (Exception e) {
            System.out.println("Bisection method failed: " + e.getMessage());
            calculationFailed = true;
        }

        solver.setRootSolver(new SecantSolver(tolerance, maxIterations));
        try {
            double rootSecant = solver.solve(lowerBound, upperBound);
            System.out.println("Secant method root: " + rootSecant);
        } catch (Exception e) {
            System.out.println("Secant method failed: " + e.getMessage());
            calculationFailed = true;
        }

        solver.setRootSolver(new NewtonRaphsonSolver(tolerance, maxIterations));
        try {
            double rootNewton = solver.solve(lowerBound, upperBound);
            System.out.println("Newton-Raphson method root: " + rootNewton);
        } catch (Exception e) {
            System.out.println("Newton-Raphson method failed: " + e.getMessage());
            calculationFailed = true;
        }

        if (calculationFailed) System.out.println("Please try again with different bounds and tolerance.");
    }

}