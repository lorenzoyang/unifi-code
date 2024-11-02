package com.github.lorenzoyang.expressions;

public abstract class UnaryExpression implements Expression {
    private final Expression subExpression;

    protected UnaryExpression(Expression subExpression) {
        this.subExpression = subExpression;
    }

    protected final Expression getSubExpression() {
        return subExpression;
    }

}
