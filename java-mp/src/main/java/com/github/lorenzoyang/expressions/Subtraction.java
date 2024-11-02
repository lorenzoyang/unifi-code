package com.github.lorenzoyang.expressions;

public class Subtraction extends BinaryExpression {
    protected Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int eval() {
        return getLeft().eval() - getRight().eval();
    }
}
