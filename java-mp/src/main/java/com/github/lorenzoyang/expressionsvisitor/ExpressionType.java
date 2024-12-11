package com.github.lorenzoyang.expressionsvisitor;

public abstract class ExpressionType {

    private static final ExpressionType INT = new ExpressionType() {
        @Override
        public String toString() {
            return "int";
        }
    };

    private static final ExpressionType BOOLEAN = new ExpressionType() {
        @Override
        public String toString() {
            return "boolean";
        }
    };

    private ExpressionType() {
    }

    public boolean isInt() {
        return this == INT;
    }

    public boolean isBoolean() {
        return this == BOOLEAN;
    }

    public static ExpressionType ofInt() {
        return INT;
    }

    public static ExpressionType ofBoolean() {
        return BOOLEAN;
    }
}

