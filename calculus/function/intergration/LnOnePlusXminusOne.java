package yukwork.calculus.function.intergration;

public class LnOnePlusXminusOne implements AbstractFunction {

    @Override
    public double evaluate(double x) {
        return MyMath.ln1p(x) - 1;
    }

    @Override
    public double derivative(double x) {
        return 1 / (x + 1);
    }

    @Override
    public String toString() {
        return "ln(1+x) - 1";
    }

}
