package com.github.lorenzoyang.expressionsvisitor;

public interface Expression {

    <T> T accept(ExpressionVisitor<T> visitor);

}
