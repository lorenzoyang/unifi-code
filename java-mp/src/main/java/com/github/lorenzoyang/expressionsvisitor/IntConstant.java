package com.github.lorenzoyang.expressionsvisitor;

public class IntConstant implements Expression {

    private int value;

    public IntConstant(int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitIntConstant(this);
    }
}
