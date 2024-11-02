package com.github.lorenzoyang.expressions;

public class Division extends BinaryExpression {
    protected Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int eval() {
        if (getRight().eval() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return getLeft().eval() / getRight().eval();
    }
}
