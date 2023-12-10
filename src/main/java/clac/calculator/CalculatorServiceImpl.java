package clac.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final Calculator calculator;

    public CalculatorServiceImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double calculate(String expression) {
        return calculator.calculate(expression);
    }
}
