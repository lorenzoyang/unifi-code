package com.github.lorenzoyang.algorithms.applications;

import java.util.Stack;

public class Calculator {
    public int calculate(String expression) {
        var postFixExpression = postFixExpression(expression);
        var stack = new Stack<Integer>();

        for (var c : postFixExpression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                var b = stack.pop();
                var a = stack.pop();
                stack.push(operate(a, b, c));
            } else {
                stack.push(Character.getNumericValue(c));
            }
        }

        return stack.pop();
    }

    private int operate(int a, int b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    private String postFixExpression(String expression) {
        var output = new StringBuilder();
        var stack = new Stack<Character>();
        for (var c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                // se il simbolo letto e' un numero, viene aggiunto al flusso di output
                output.append(c);
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                // se e' una parentesi aperta, non viene fatto nulla
                if (c == '(') {
                    continue;
                }
                // se il simbolo letto e' una parentesi chiusa, vuol dire che entrambi gli argomenti dell’ultimo
                // operatore sono stati scritti sul flusso di output,
                // percio' viene estratto l’operatore dalla pila e scritto sul flusso di output.
                if (c == ')') {
                    output.append(stack.pop());
                    continue;
                }
                // se il simbolo letto e' un operatore aritmetico, viene caricato nella pila
                stack.push(c);
            } else {
                // se il simbolo letto non e' valido
                if (c != ' ')
                    throw new IllegalArgumentException("Invalid character in expression: " + c);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        var calculator = new Calculator();
        System.out.println(calculator.calculate("((1+2)*3)"));
        System.out.println(calculator.calculate("(5*(((9+8)*(4+6))+7))"));
    }
}
