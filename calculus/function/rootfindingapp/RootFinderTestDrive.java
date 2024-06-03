package yukwork.calculus.function.rootfindingapp;

import java.util.Scanner;
import java.util.function.Function;

public class RootFinderTestDrive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the function (in terms of x): ");
        String functionExpr = scanner.nextLine();
        Function<Double, Double> func = FunctionEvaluator.createFunction(functionExpr);

        System.out.print("Enter the initial guess or range (a b): ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        System.out.print("Enter the tolerance: ");
        double tol = scanner.nextDouble();

        System.out.println("Choose the method: 1. Bisection 2. Secant 3. Newton-Raphson");
        int choice = scanner.nextInt();

        RootFinder rootFinder = new RootFinder();

        switch (choice) {
            case 1:
                rootFinder.setStrategy(new BisectionMethod());
                break;
            case 2:
                rootFinder.setStrategy(new SecantMethod());
                break;
            case 3:
                rootFinder.setStrategy(new NewtonRaphsonMethod());
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        double root = rootFinder.findRoot(func, a, b, tol);
        System.out.println("Root: " + root);
    }

}

