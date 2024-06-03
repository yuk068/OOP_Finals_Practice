package yukwork.calculus.function.intergration;

public class IntegrationCalculatorTestDrive {

    public static void main(String[] args) {
        System.out.println("Integration: ");
        testIntegrationCalculator();
    }


    public static void testIntegrationCalculator() {
        AbstractFunction function = new SinXtimesXplusThree();

        double lower = 0.0;
        double upper = 1.0;
        System.out.println("Function: " + function + "; lower: " + lower + "; upper: " + upper);

        Integrator midpointRule = new MidpointMethod(1e-6, 101);
        Integrator trapezoidRule = new TrapezoidMethod(1e-6, 101);
        Integrator simpsonRule = new SimpsonMethod(1e-6, 101);

        IntegrationCalculator calculator = new IntegrationCalculator(function);

        calculator.setIntegrator(midpointRule);
        double midpointResult = calculator.integrate(lower, upper);
        System.out.println("Midpoint Rule Integration: " + midpointResult);

        calculator.setIntegrator(trapezoidRule);
        double trapezoidResult = calculator.integrate(lower, upper);
        System.out.println("Trapezoid Rule Integration: " + trapezoidResult);

        calculator.setIntegrator(simpsonRule);
        double simpsonResult = calculator.integrate(lower, upper);
        System.out.println("Simpson Rule Integration: " + simpsonResult);
    }

}
