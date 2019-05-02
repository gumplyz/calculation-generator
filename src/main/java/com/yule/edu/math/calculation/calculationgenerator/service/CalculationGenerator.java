package com.yule.edu.math.calculation.calculationgenerator.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class CalculationGenerator {
    public Collection<String> generate(int numsOfQuestions, IOperationStrategy[] operationStrategies) {
        Collection<String> questions = new ArrayList<>(numsOfQuestions);
        while (numsOfQuestions > questions.size()) {
            IOperationStrategy strategy = operationStrategies[ThreadLocalRandom.current().nextInt(0, operationStrategies.length)];
            questions.add(strategy.generate());
        }
        return questions;
    }
}
