package yukwork.calculus.polynomials.rootfinding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayPolynomial extends AbstractPolynomial {

    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficients;
    private int size;

    public ArrayPolynomial() {
        coefficients = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public double coefficientAt(int index) {
        checkBoundaries(index, size - 1);
        return coefficients[index];
    }

    @Override
    public double[] coefficients() {
        return Arrays.copyOf(coefficients, size);
    }

    public void insertAtStart(double coefficient) {
        insertAtPosition(0, coefficient);
    }

    public void insertAtEnd(double coefficient) {
        insertAtPosition(size, coefficient);
    }

    public void insertAtPosition(int index, double coefficient) {
        checkBoundaries(index, size);
        if (size >= coefficients().length) allocateMore();
        System.arraycopy(coefficients, index, coefficients, index + 1, size - index);
        coefficients[index] = coefficient;
        size++;
    }

    public void set(int index, double coefficient) {
        checkBoundaries(index, size - 1);
        coefficients[index] = coefficient;
    }

    @Override
    public int degree() {
        return size - 1;
    }

    @Override
    public double evaluate(double x) {
        double evaluation = coefficients[0];
        for (int i = 1; i < size; i++) {
            evaluation += Math.pow(x, i) * coefficients[i];
        }

        return evaluation;
    }

    @Override
    public Polynomial derivative() {
        List<Double> derivatives = Arrays.stream(differentiate())
                .boxed()
                .toList();
        Polynomial derived = new ArrayPolynomial();
        derivatives.forEach(derived::insertAtEnd);
        return derived;
    }

    public ArrayPolynomial plus(ArrayPolynomial another) {
        int operationalDegree = Math.min(degree(), another.degree());
        int maxDegree = Math.max(degree(), another.degree());
        ArrayPolynomial result = new ArrayPolynomial();

        for (int i = 0; i <= operationalDegree; i++) {
            result.insertAtEnd(coefficientAt(i) + another.coefficientAt(i));
        }
        IntStream.rangeClosed(operationalDegree + 1, maxDegree)
                .mapToDouble(i -> degree() > another.degree() ? coefficientAt(i) : another.coefficientAt(i))
                .forEach(result::insertAtEnd);

        return result;
    }

    public ArrayPolynomial minus(ArrayPolynomial another) {
        int operationalDegree = Math.min(degree(), another.degree());
        int maxDegree = Math.max(degree(), another.degree());
        ArrayPolynomial result = new ArrayPolynomial();

        for (int i = 0; i <= operationalDegree; i++) {
            result.insertAtEnd(coefficientAt(i) - another.coefficientAt(i));
        }
        IntStream.rangeClosed(operationalDegree + 1, maxDegree)
                .mapToDouble(i -> degree() > another.degree() ? coefficientAt(i) : -another.coefficientAt(i))
                .forEach(result::insertAtEnd);

        return result;
    }

    public ArrayPolynomial multiply(ArrayPolynomial another) {
        int maxDegree = degree() + another.degree();
        ArrayPolynomial result = new ArrayPolynomial();

        IntStream.range(0, maxDegree + 1)
                .forEach(i -> result.insertAtEnd(0));

        for (int i = 0; i <= degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                int termDegree = i + j;
                double termCoefficient = coefficientAt(i) * another.coefficientAt(j);
                result.set(termDegree, result.coefficientAt(termDegree) + termCoefficient);
            }
        }

        return result;
    }

    private void allocateMore() {
        double[] newCoeffs = new double[coefficients.length * 2];
        System.arraycopy(coefficients, 0, newCoeffs, 0, size);
        coefficients = newCoeffs;
    }

}
