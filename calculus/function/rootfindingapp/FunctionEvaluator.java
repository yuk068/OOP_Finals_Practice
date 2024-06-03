package yukwork.calculus.function.rootfindingapp;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.function.Function;

public class FunctionEvaluator {

    public static Function<Double, Double> createFunction(String expression) {
        return x -> {
            Expression e = new ExpressionBuilder(expression)
                    .variable("x")
                    .build()
                    .setVariable("x", x);
            return e.evaluate();
        };
    }

}

