package yukwork.calculus.polynomials.rootfinding;

public interface Polynomial {

    double coefficientAt(int index);

    double[] coefficients();

    void insertAtStart(double coefficient);

    void insertAtEnd(double coefficient);

    void insertAtPosition(int index, double coefficient);

    void set(int index, double coefficient);

    int degree();

    double evaluate(double x);

    Polynomial derivative();

}
