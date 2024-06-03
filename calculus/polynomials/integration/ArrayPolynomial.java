package yukwork.calculus.polynomials.integration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayPolynomial extends AbstractPolynomial {

    private static final int DEFAULT_CAPACITY = 4;
    private double[] coefficients;
    private int size;

    public ArrayPolynomial() {
        coefficients = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public double coefficient(int index) {
        checkBoundaries(index, size);
        return coefficients[index];
    }

    @Override
    public double[] coefficients() {
        return coefficients;
    }

    public ArrayPolynomial append(double coefficient) {
        if (size >= coefficients.length) enlarge();
        coefficients[size++] = coefficient;
        return this;
    }

    public ArrayPolynomial insert(double coefficient, int index) {
        checkBoundaries(index, size + 1);
        if (size >= coefficients.length) enlarge();
        System.arraycopy(coefficients, index, coefficients, index + 1, size - index);
        coefficients[index] = coefficient;
        size++;
        return this;
    }

    public ArrayPolynomial set(int index, double coefficient) {
        checkBoundaries(index, size);
        coefficients[index] = coefficient;
        return this;
    }

    @Override
    public int degree() {
        return size - 1;
    }

    @Override
    public double evaluate(double x) {
        double evaluation = coefficients[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            evaluation = evaluation * x + coefficients[i];
        }
        return evaluation;
    }

    @Override
    public Polynomial derivative() {
        List<Double> derivatives = Arrays.stream(differentiate())
                .boxed()
                .toList();
        ArrayPolynomial derived = new ArrayPolynomial();
        derivatives.forEach(derived::append);
        return derived;
    }

    public ArrayPolynomial plus(ArrayPolynomial another) {
        int operationalDegree = Math.min(degree(), another.degree());
        int maxDegree = Math.max(degree(), another.degree());
        ArrayPolynomial result = new ArrayPolynomial();

        for (int i = 0; i <= operationalDegree; i++) {
            result.append(coefficients[i] + another.coefficients[i]);
        }
        IntStream.rangeClosed(operationalDegree + 1, maxDegree)
                .mapToDouble(i -> degree() > another.degree() ? coefficients[i] : another.coefficients[i])
                .forEach(result::append);

        return result;
    }

    public ArrayPolynomial minus(ArrayPolynomial another) {
        int operationalDegree = Math.min(degree(), another.degree());
        int maxDegree = Math.max(degree(), another.degree());
        ArrayPolynomial result = new ArrayPolynomial();

        for (int i = 0; i <= operationalDegree; i++) {
            result.append(coefficients[i] - another.coefficients[i]);
        }
        IntStream.rangeClosed(operationalDegree + 1, maxDegree)
                .mapToDouble(i -> degree() > another.degree() ? coefficients[i] : -another.coefficients[i])
                .forEach(result::append);

        return result;
    }

    public ArrayPolynomial multiply(ArrayPolynomial another) {
        int maxDegree = degree() + another.degree();
        ArrayPolynomial result = new ArrayPolynomial();

        IntStream.range(0, maxDegree + 1)
                .forEach(i -> result.append(0));

        for (int i = 0; i <= degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                int termDegree = i + j;
                double termCoefficient = coefficients[i] * another.coefficients[j];
                result.set(termDegree, result.coefficients[termDegree] + termCoefficient);
            }
        }

        return result;
    }

    private void enlarge() {
        double[] newCoeffs = new double[size * 2];
        System.arraycopy(coefficients, 0, newCoeffs, 0, size);
        coefficients = newCoeffs;
    }

}
