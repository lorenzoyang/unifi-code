package com.github.lorenzoyang.expressionsvisitor;

public class ExpressionTypeSystemVisitor implements ExpressionVisitor<ExpressionType> {

    @Override
    public ExpressionType visitIntConstant(IntConstant intConstant) {
        return ExpressionType.ofInt();
    }

    @Override
    public ExpressionType visitBooleanConstant(BooleanConstant booleanConstant) {
        return ExpressionType.ofBoolean();
    }

    @Override
    public ExpressionType visitSum(Sum sum) {
        checkIntType(sum.getLeft().accept(this));
        checkIntType(sum.getRight().accept(this));
        return ExpressionType.ofInt();
    }

    private void checkIntType(ExpressionType type) {
        if (!type.isInt()) {
            throw new ExpressionTypeException("Expected int but was " + type);
        }
    }

    @Override
    public ExpressionType visitEqual(Equal equal) {
        equal.getLeft().accept(this);
        equal.getRight().accept(this);
        return ExpressionType.ofBoolean();
    }

    @Override
    public ExpressionType visitAnd(And and) {
        checkBooleanType(and.getLeft().accept(this));
        checkBooleanType(and.getRight().accept(this));
        return ExpressionType.ofBoolean();
    }

    private void checkBooleanType(ExpressionType type) {
        if (!type.isBoolean()) {
            throw new ExpressionTypeException("Expected boolean but was " + type);
        }
    }

}
