package com.github.lorenzoyang.expressionsvisitor;

public class BooleanConstant implements Expression {

    private boolean value;

    public BooleanConstant(boolean value) {
        this.value = value;
    }

    public final boolean getValue() {
        return value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitBooleanConstant(this);
    }
}

