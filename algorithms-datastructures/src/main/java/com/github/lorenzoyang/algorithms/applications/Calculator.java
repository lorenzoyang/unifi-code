package com.github.lorenzoyang.algorithms.applications;

import com.github.lorenzoyang.algorithms.datastructures.LinkedStack;

/**
 * L'uso della pila per la valutazione di espressioni aritmetiche
 * nelle espressioni aritmetiche vengono esplicitate tutte le parentesi necessarie
 * e dunque non si sottointende nessun critetio di precedenza tra le operazioni
 * <p>
 * Supporta solo le espressioni aritmetiche con i numeri di una sola cifra
 */
public class Calculator {

    // lo stack degli operatori
    private final LinkedStack<Character> operators;
    // lo stack degli operandi
    private final LinkedStack<Integer> operands;

    /**
     * costruttore, inizializza gli stack
     */
    public Calculator() {
        this.operators = new LinkedStack<>();
        this.operands = new LinkedStack<>();
    }

    /**
     * valuta l'espressione aritmetica e restituisce il risultato.
     * <p>
     * Supporta solo le espressioni aritmetiche con i numeri di una sola cifra
     */
    public Number evaluate(String expression) {
        String postFix = postFix(expression);
        for (char c : postFix.toCharArray()) {
            if (Character.isDigit(c)) {
                // se il simbolo letto e' un numero, viene caricato nella pila
                operands.push(Character.getNumericValue(c));
            } else {
                if (c != '+' && c != '-' && c != '*' && c != '/') {
                    throw new IllegalArgumentException("Invalid character in expression: " + c);
                }
                // se il simbolo letto e' un operatore aritmetico,
                // vengono estratti gli ultimi due argomenti caricati nella pila,
                // viene loro applicato l’operatore e il risultato viene caricato nella pila
                int operand2 = operands.pop();
                int operand1 = operands.pop();
                switch (c) {
                    case '+':
                        operands.push(operand1 + operand2);
                        break;
                    case '-':
                        operands.push(operand1 - operand2);
                        break;
                    case '*':
                        operands.push(operand1 * operand2);
                        break;
                    case '/':
                        if (operand2 == 0) {
                            throw new IllegalArgumentException("Division by zero is not allowed");
                        }
                        operands.push(operand1 / operand2);
                        break;
                }
            }
        }
        return operands.pop();
    }

    /**
     * la trasformazione dell’espressione infissa completamente parentesizzata
     * in forma postfissa
     */
    private String postFix(String expression) {
        // il flusso di output
        var output = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                // se il simbolo letto e' un numero, viene aggiunto al flusso di output
                output.append(c);
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                // se e' una parentesi aperta, non viene fatto nulla
                if (c == '(') {
                    continue;
                }
                // se il simbolo letto e una parentesi chiusa, vuol dire che entrambi gli argomenti dell’ultimo
                // operatore sono stati scritti sul flusso di output,
                // percio' viene estratto l’operatore dalla pila e scritto sul flusso di output.
                if (c == ')') {
                    output.append(operators.pop());
                    continue;
                }
                // se il simbolo letto e' un operatore aritmetico, viene caricato nella pila
                operators.push(c);
            } else {
                // se il simbolo letto non e' valido
                if (c != ' ')
                    throw new IllegalArgumentException("Invalid character in expression: " + c);
            }
        }
        return output.toString();
    }

    // test
    public static void main(String[] args) {
        var calculator = new Calculator();
        System.out.println(calculator.evaluate("(5 * (((9+8) * (4 * 6)) +7))"));
    }
}
