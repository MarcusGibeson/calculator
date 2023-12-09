package clac.calculator;

import java.util.List;


public interface CalculatorService {
    Double calculate(String expression);

    void storeFunction(String expression, Double result);

    List<Calculator> getStoredFunctions();
}
