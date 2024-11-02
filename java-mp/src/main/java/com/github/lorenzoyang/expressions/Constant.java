package com.github.lorenzoyang.expressions;

public final class Constant implements Expression {
    private final int constantValue;

    public Constant(int constantValue) {
        this.constantValue = constantValue;
    }

    @Override
    public int eval() {
        return constantValue;
    }
}
