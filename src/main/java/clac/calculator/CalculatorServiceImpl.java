package clac.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private List<Calculator> storedFunctions = new ArrayList<>();

    @Override
    public Double calculate(String expression) {
        try (
            ExpressionBuilder expressionBuilder = new ExpressionBuilder(expression);
            return expressionBuilder.build().evaluate();
        )
    }
}
