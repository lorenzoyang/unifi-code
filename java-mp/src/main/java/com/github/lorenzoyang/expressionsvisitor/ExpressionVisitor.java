package com.github.lorenzoyang.expressionsvisitor;

public interface ExpressionVisitor<T> {

    T visitIntConstant(IntConstant intConstant);

    T visitBooleanConstant(BooleanConstant booleanConstant);

    T visitSum(Sum sum);

    T visitEqual(Equal equal);

    T visitAnd(And and);
}