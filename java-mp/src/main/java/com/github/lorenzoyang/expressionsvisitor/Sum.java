package com.github.lorenzoyang.expressionsvisitor;

public class Sum extends BinaryExpression {

    public Sum(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitSum(this);
    }

}
