package com.github.lorenzoyang.expressions;

import java.util.stream.IntStream;

public class Factorial extends UnaryExpression {
    protected Factorial(Expression subExpression) {
        super(subExpression);
    }

    @Override
    public int eval() {
        int n = getSubExpression().eval();
        return IntStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
    }
}
