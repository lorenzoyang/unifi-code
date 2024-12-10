package com.github.lorenzoyang.expressionsvisitor;

public class ExpressionEvaluatorVisitor implements ExpressionVisitor<ExpressionEvalResult> {

    @Override
    public ExpressionEvalResult visitIntConstant(IntConstant intConstant) {
        return ExpressionEvalResult.ofInt(intConstant.getValue());
    }

    @Override
    public ExpressionEvalResult visitBooleanConstant(BooleanConstant booleanConstant) {
        return ExpressionEvalResult.ofBoolean(booleanConstant.getValue());
    }

    @Override
    public ExpressionEvalResult visitSum(Sum sum) {
        return ExpressionEvalResult.ofInt(
                sum.getLeft().accept(this).asInt()
                        +
                        sum.getRight().accept(this).asInt()
        );
    }

    @Override
    public ExpressionEvalResult visitEqual(Equal equal) {
        return ExpressionEvalResult.ofBoolean(
                equal.getLeft().accept(this).getValue()
                        .equals(equal.getRight().accept(this).getValue()));
    }

    @Override
    public ExpressionEvalResult visitAnd(And and) {
        return ExpressionEvalResult.ofBoolean(
                and.getLeft().accept(this).asBoolean()
                        &&
                        and.getRight().accept(this).asBoolean()
        );
    }

}
