package com.github.lorenzoyang.expressions;

public abstract class BinaryExpression implements Expression {
    private final Expression left;
    private final Expression right;

    protected BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    protected final Expression getLeft() {
        return left;
    }

    protected final Expression getRight() {
        return right;
    }
}
