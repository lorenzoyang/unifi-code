package com.github.lorenzoyang.expressions;

public class Sum extends BinaryExpression implements Expression {

    public Sum(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int eval() {
        return getLeft().eval() + getRight().eval();
    }
}
