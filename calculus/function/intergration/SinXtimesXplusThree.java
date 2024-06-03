package yukwork.calculus.function.intergration;

public class SinXtimesXplusThree implements AbstractFunction {

    @Override
    public double evaluate(double x) {
        return MyMath.sin(x) * x + 3;
    }

    @Override
    public double derivative(double x) {
        return MyMath.cos(x) * x + MyMath.sin(x);
    }

    @Override
    public String toString() {
        return "sin(x)*x + 3";
    }

}
