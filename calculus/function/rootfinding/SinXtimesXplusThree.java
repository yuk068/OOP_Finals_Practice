package yukwork.calculus.function.rootfinding;

public class SinXtimesXplusThree implements AbstractFunction {

    @Override
    public double evaluate(double x) {
        return MyMath.sin(x) * x + 3;
    }

    @Override
    public double derivative(double x) {
        return MyMath.cos(x) * x + MyMath.sin(x);
    }

}
