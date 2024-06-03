package yukwork.calculus.polynomials.integration;

public interface Polynomial {

    double coefficient(int index);

    double[] coefficients();

    int degree();

    double evaluate(double x);

    Polynomial derivative();

}
