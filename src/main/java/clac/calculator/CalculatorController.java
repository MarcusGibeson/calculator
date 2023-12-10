package clac.calculator;

import org.springframework.stereotype.Controller;

@Controller
public class CalculatorController {
    
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String calculator(Model model) {
        List
    }
}
