package yukwork.calculus.polynomials.rootfinding;

public abstract class AbstractPolynomial implements Polynomial {

    public void checkBoundaries(int index, int limit) {
        if (index < 0 && index > limit) throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        StringBuilder polynomial = new StringBuilder();
        int degree = coefficients().length - 1;

        for (int i = degree; i >= 0; i--) {
            double coeff = coefficientAt(i);

            if (coeff != 0) {
                if (!polynomial.isEmpty() && coeff > 0) {
                    polynomial.append(" + ");
                }

                if (coeff < 0) {
                    polynomial.append(" - ");
                    coeff = -coeff;
                }

                if (i == 0 || coeff != 1) {
                    polynomial.append(coeff);
                }

                if (i > 0) {
                    polynomial.append("x");
                    if (i > 1) {
                        polynomial.append("^").append(i);
                    }
                }
            }
        }

        return polynomial.toString().trim();
    }

    public double[] differentiate() {
            if (degree() == 0) {
                return new double[]{0};
            }

            double[] derived = new double[degree()];
            for (int i = 1; i < degree() + 1; i++) {
                derived[i - 1] = coefficientAt(i) * i;
            }
            return derived;
    }

}
