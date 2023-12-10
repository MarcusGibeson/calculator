package clac.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    
    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("")
    public String showCalculator(Model model) {
        model.addAttribute("calculator", calculator);
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculateExpression(@RequestParam String expression, Model model){
        double result = calculator.calculate(expression);
        calculator.setResult(result);
        model.addAttribute("calculator", calculator);
        return "calculator";

    }
}
