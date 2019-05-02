package com.yule.edu.math.calculation.calculationgenerator.restapi.controller;

import com.yule.edu.math.calculation.calculationgenerator.service.AdditionStrategy;
import com.yule.edu.math.calculation.calculationgenerator.service.CalculationGenerator;
import com.yule.edu.math.calculation.calculationgenerator.service.IOperationStrategy;
import com.yule.edu.math.calculation.calculationgenerator.service.Parameters;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CalculationGeneratorController {

    private final CalculationGenerator calculationGenerator;

    public CalculationGeneratorController(CalculationGenerator calculationGenerator) {
        this.calculationGenerator = calculationGenerator;
    }

    @PostMapping("/math/calculation/generator")
    public Collection<String> generator(@RequestBody Parameters parameters) {
        List<IOperationStrategy> strategies = new ArrayList<>();
        IOperationStrategy add = AdditionStrategy.take(parameters);
        if (add != null) {
            strategies.add(add);
        }

        return calculationGenerator.generate(parameters.getNumQuestions(), strategies.toArray(new IOperationStrategy[0]));
    }
}
