package com.yule.edu.math.calculation.calculationgenerator.restapi.controller;

import com.yule.edu.math.calculation.calculationgenerator.service.AdditionWithCarryStrategy;
import com.yule.edu.math.calculation.calculationgenerator.service.CalculationGenerator;
import com.yule.edu.math.calculation.calculationgenerator.service.IOperationStrategy;
import com.yule.edu.math.calculation.calculationgenerator.service.Parameters;
import com.yule.edu.math.calculation.calculationgenerator.service.SubtractionStrategy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    IOperationStrategy add = AdditionWithCarryStrategy.take(parameters);
    if (add != null) {
      strategies.add(add);
    }

    IOperationStrategy substract = SubtractionStrategy.take(parameters);
    if (substract != null) {
      strategies.add(substract);
    }

    return calculationGenerator.generate(parameters.getNumQuestions(), strategies.toArray(new IOperationStrategy[0]));
  }
}
