package com.github.lorenzoyang.expressionsvisitor;

public abstract class ExpressionEvalResult {

    private ExpressionEvalResult() {
    }

    public abstract Object getValue();

    public int asInt() {
        throw new ExpressionEvalResultException("Not a valid int: " + getValue());
    }

    public boolean asBoolean() {
        throw new ExpressionEvalResultException("Not a valid boolean: " + getValue());
    }

    public static ExpressionEvalResult ofInt(int value) {
        return new ExpressionEvalResult() {
            @Override
            public int asInt() {
                return value;
            }

            @Override
            public Object getValue() {
                return value;
            }
        };
    }

    public static ExpressionEvalResult ofBoolean(boolean value) {
        return new ExpressionEvalResult() {
            @Override
            public boolean asBoolean() {
                return value;
            }

            @Override
            public Object getValue() {
                return value;
            }
        };
    }
}