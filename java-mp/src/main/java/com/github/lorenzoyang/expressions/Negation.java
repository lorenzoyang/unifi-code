package com.github.lorenzoyang.expressions;

public class Negation extends UnaryExpression {
    protected Negation(Expression subExpression) {
        super(subExpression);
    }

    @Override
    public int eval() {
        return -getSubExpression().eval();
    }
}
