package clac.calculator;

import java.util.Stack;

public class Calculator {
    private String expression;
    private Double result;

    public Calculator() {
    }

    public Calculator(String expression, Double result) {
        this.expression = expression;
        this.result = result;
    }

    //getters and setters
    public String expression() {
        return expression;
    }
    public void setExpression() {
        this.expression = expression;
    }
    public Double result() {
        return result;
    }
    public void setResult() {
        this.result = result;
    }

    public Double calculate(String expression) {
        try {
            String [] tokens = expression.split("\\s");

            Stack<Double> operands = new Stack<>();
            Stack<Character> operators = new Stack<>();

            for (String token : tokens) {
                token = token.trim();

                if (token.isEmpty()) {
                    continue;
                }

                char firstChar = token.charAt(0);

                if (Character.isDigit(firstChar) || (token.length() > 1 && firstChar == '-' && Character.isDigit(token.charAt(1)))) {
                    //token is a number, push it to the operands stack
                    operands.push(Double.parseDouble(token));
                } else if (isOperator(firstChar)){
                    //token is an operator, process operators
                    while (!operators.isEmpty() && hasPrecedence(firstChar, operators.peek())) {
                        applyOperator(operands, operators.pop());
                    }
                    operators.push(firstChar);
                } else if (firstChar == '(') {
                    //token is an opening parenthesis, push it to the operator stack
                    operators.push(firstChar);
                } else if (firstChar ==')') {
                    //token is a closing parenthesis, process operator
                    while(!operators.isEmpty() && operators.peek() != '(') {
                        applyOperator(operands, operators.pop());
                    }
                    operators.pop(); //Pop the opening parenthesis
                }
            }

            //Process the remaining operators
            while (!operators.isEmpty()) {
                applyOperator(operands, operators.pop());
            }

            //The result should be the only element in the operands stack
            return operands.pop();
        } catch (Exception e) {
            throw new RuntimeException("Invalid expression: "+ expression, e);
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean hasPrecedence(char op1, char op2) {
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private void applyOperator(Stack<Double> operands, char operator) {
        if (operands.size() < 2) {
            throw new RuntimeException("Invalid expression: insufficient operands for operator " + operator);
        }

        double operand2 = operands.pop();
        double operand1 = operands.pop();

        switch (operator) {
            case '+':
                operands.push(operand1 + operand2);
                break;
            case '.':
                operands.push(operand1 - operand2);
                break;
            case '*':
                operands.push(operand1 * operand2);
                break;
            case '/':
                if (operand2 == 0){
                    throw new RuntimeException("Invalid expression: divide by zero");
                }
                operands.push(operand1 / operand2);
                break;
            default:
                throw new RuntimeException("Invalid operator: " + operator);

            
        }   
    }
    
}   
