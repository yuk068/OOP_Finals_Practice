package yukwork.calculus.polynomials.integration;

public class IntegrationCalculatorTestDrive {

    public static void main(String[] args) {
        testArrayPolynomial();
        testListPolynomial();
        testIntegrationCalculator();
    }

    public static void testArrayPolynomial() {
        ArrayPolynomial poly1 = new ArrayPolynomial();
        ArrayPolynomial poly2 = new ArrayPolynomial();
        
        poly1.append(1);
        poly1.append(2);  
        poly1.append(3);  
        
        poly2.append(3);  
        poly2.append(4);  
        poly2.append(5);  
        
        poly1.set(0, 2); 
        poly2.set(2, 6); 
        
        System.out.println("Polynomial 1 coefficients: " + poly1);
        System.out.println("Polynomial 2 coefficients: " + poly2);
        
        ArrayPolynomial sum = poly1.plus(poly2);
        System.out.println("Sum of polynomials coefficients: " + sum);
        
        ArrayPolynomial difference = poly1.minus(poly2);
        System.out.println("Difference of polynomials coefficients: " + difference);
        
        ArrayPolynomial product = poly1.multiply(poly2);
        System.out.println("Product of polynomials coefficients: " + product);
        
        double x = 2.0;
        double valuePoly1 = poly1.evaluate(x);
        double valuePoly2 = poly2.evaluate(x);
        System.out.println("Value of Polynomial 1 at x = " + x + ": " + valuePoly1);
        System.out.println("Value of Polynomial 2 at x = " + x + ": " + valuePoly2);
        
        Polynomial derivativePoly1 = poly1.derivative();
        Polynomial derivativePoly2 = poly2.derivative();
        System.out.println("Derivative of Polynomial 1 coefficients: " + derivativePoly1);
        System.out.println("Derivative of Polynomial 2 coefficients: " + derivativePoly2);
    }

    public static void testListPolynomial() {
        ListPolynomial poly1 = new ListPolynomial();
        ListPolynomial poly2 = new ListPolynomial();
        
        poly1.append(1);  
        poly1.append(2);  
        poly1.append(3);  
        
        poly2.append(3);  
        poly2.append(4);  
        poly2.append(5);  
        
        poly1.set(0, 2); 
        poly2.set(2, 6); 
        
        System.out.println("Polynomial 1 coefficients: " + poly1);
        System.out.println("Polynomial 2 coefficients: " + poly2);
        
        ListPolynomial sum = poly1.plus(poly2);
        System.out.println("Sum of polynomials coefficients: " + sum);
        
        ListPolynomial difference = poly1.minus(poly2);
        System.out.println("Difference of polynomials coefficients: " + difference);
        
        ListPolynomial product = poly1.multiply(poly2);
        System.out.println("Product of polynomials coefficients: " + product);
        
        double x = 2.0;
        double valuePoly1 = poly1.evaluate(x);
        double valuePoly2 = poly2.evaluate(x);
        System.out.println("Value of Polynomial 1 at x = " + x + ": " + valuePoly1);
        System.out.println("Value of Polynomial 2 at x = " + x + ": " + valuePoly2);
        
        Polynomial derivativePoly1 = poly1.derivative();
        Polynomial derivativePoly2 = poly2.derivative();
        System.out.println("Derivative of Polynomial 1 coefficients: " + derivativePoly1);
        System.out.println("Derivative of Polynomial 2 coefficients: " + derivativePoly2);
    }

    public static void testIntegrationCalculator() {
        ArrayPolynomial poly = new ArrayPolynomial();
        poly.append(1); 
        poly.append(2); 
        poly.append(3); 
        
        double lower = 0.0;
        double upper = 1.0;
        System.out.println("Polynomial: " + poly + "; lower: " + lower + "; upper: " + upper);
        
        Integrator midpointRule = new MidpointRule(1e-6, 101);
        Integrator trapezoidRule = new TrapezoidRule(1e-6, 101);
        Integrator simpsonRule = new SimpsonRule(1e-6, 101);
        
        IntegrationCalculator calculator = new IntegrationCalculator(poly);
        
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
