package yukwork.calculus.polynomials.rootfinding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ListPolynomial extends AbstractPolynomial {

    private final List<Double> coefficients;

    public ListPolynomial() {
        coefficients = new LinkedList<>();
    }

    @Override
    public double coefficientAt(int index) {
        checkBoundaries(index, coefficients.size() - 1);
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        return coefficients.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public void insertAtStart(double coefficient) {
        coefficients.addFirst(coefficient);
    }

    public void insertAtEnd(double coefficient) {
        coefficients.addLast(coefficient);
    }

    public void insertAtPosition(int index, double coefficient) {
        checkBoundaries(index, coefficients.size());
        coefficients.add(index, coefficient);
    }

    public void set(int index, double coefficient) {
        checkBoundaries(index, coefficients.size() - 1);
        coefficients.set(index, coefficient);
    }

    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    @Override
    public double evaluate(double x) {
        return IntStream.range(0, degree() + 1)
                .mapToDouble(i -> coefficients.get(i) * Math.pow(x, i))
                .sum();
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

    public ListPolynomial plus(ListPolynomial another) {
        int operationalDegree = Math.min(degree(), another.degree());
        int maxDegree = Math.max(degree(), another.degree());
        ListPolynomial result = new ListPolynomial();

        for (int i = 0; i <= operationalDegree; i++) {
            result.insertAtEnd(coefficientAt(i) + another.coefficientAt(i));
        }
        IntStream.rangeClosed(operationalDegree + 1, maxDegree)
                .mapToDouble(i -> degree() > another.degree() ? coefficientAt(i) : another.coefficientAt(i))
                .forEach(result::insertAtEnd);

        return result;
    }

    public ListPolynomial minus(ListPolynomial another) {
        int operationalDegree = Math.min(degree(), another.degree());
        int maxDegree = Math.max(degree(), another.degree());
        ListPolynomial result = new ListPolynomial();

        for (int i = 0; i <= operationalDegree; i++) {
            result.insertAtEnd(coefficientAt(i) - another.coefficientAt(i));
        }
        IntStream.rangeClosed(operationalDegree + 1, maxDegree)
                .mapToDouble(i -> degree() > another.degree() ? coefficientAt(i) : -another.coefficientAt(i))
                .forEach(result::insertAtEnd);

        return result;
    }

    public ListPolynomial multiply(ListPolynomial another) {
        int maxDegree = degree() + another.degree();
        ListPolynomial result = new ListPolynomial();

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

}
