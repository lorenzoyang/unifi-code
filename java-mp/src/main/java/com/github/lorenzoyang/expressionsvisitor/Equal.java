package com.github.lorenzoyang.expressionsvisitor;

public class Equal extends BinaryExpression {

    public Equal(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitEqual(this);
    }

}

