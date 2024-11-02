package com.github.lorenzoyang.expressions;

public class Multiplication extends BinaryExpression {
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int eval() {
        return getLeft().eval() * getRight().eval();
    }
}
