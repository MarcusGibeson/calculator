package clac.calculator;

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
}   
