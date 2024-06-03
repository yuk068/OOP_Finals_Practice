package yukwork.calculus.polynomials.integration;

import java.util.LinkedList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private final List<Double> coefficients;

    public ListPolynomial() {
        coefficients = new LinkedList<>();
    }

    @Override
    public double coefficient(int index) {
        checkBoundaries(index, coefficients.size());
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        return coefficients.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public ListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    public ListPolynomial insert(double coefficient, int index) {
        checkBoundaries(index, coefficients.size() + 1);
        coefficients.add(index, coefficient);
        return this;
    }

    public ListPolynomial set(int index, double coefficient) {
        checkBoundaries(index, coefficients.size());
        coefficients.set(index, coefficient);
        return this;
    }

    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    @Override
    public double evaluate(double x) {
        double evaluation = coefficients.get(0);
        for (int i = 1; i < coefficients.size(); i++) {
            evaluation += Math.pow(x, i) * coefficients.get(i);
        }
        return evaluation;
    }

    @Override
    public Polynomial derivative() {
        if (coefficients.size() <= 1) {
            return new ListPolynomial();
        }
        ListPolynomial derivativePolynomial = new ListPolynomial();
        for (int i = 1; i < coefficients.size(); i++) {
            derivativePolynomial.append(i * coefficients.get(i));
        }
        return derivativePolynomial;
    }

    public ListPolynomial plus(ListPolynomial another) {
        ListPolynomial result = new ListPolynomial();
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());

        for (int i = 0; i < maxSize; i++) {
            double thisCoeff = i < this.coefficients.size() ? this.coefficients.get(i) : 0;
            double anotherCoeff = i < another.coefficients.size() ? another.coefficients.get(i) : 0;
            result.append(thisCoeff + anotherCoeff);
        }
        return result;
    }

    public ListPolynomial minus(ListPolynomial another) {
        ListPolynomial result = new ListPolynomial();
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());

        for (int i = 0; i < maxSize; i++) {
            double thisCoeff = i < this.coefficients.size() ? this.coefficients.get(i) : 0;
            double anotherCoeff = i < another.coefficients.size() ? another.coefficients.get(i) : 0;
            result.append(thisCoeff - anotherCoeff);
        }
        return result;
    }

    public ListPolynomial multiply(ListPolynomial another) {
        int newDegree = this.coefficients.size() + another.coefficients.size() - 1;
        ListPolynomial result = new ListPolynomial();

        for (int i = 0; i < newDegree; i++) {
            result.append(0.0);
        }

        for (int i = 0; i < this.coefficients.size(); i++) {
            for (int j = 0; j < another.coefficients.size(); j++) {
                double currentValue = result.coefficients.get(i + j);
                result.coefficients.set(i + j, currentValue + this.coefficients.get(i) * another.coefficients.get(j));
            }
        }
        return result;
    }

}
