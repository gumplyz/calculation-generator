package com.yule.edu.math.calculation.calculationgenerator.service;

import java.util.concurrent.ThreadLocalRandom;

public class SubtractionStrategy implements IOperationStrategy {
    private int op2;
    private int max;

    public SubtractionStrategy(int op2, int max) {
        this.op2 = op2;
        this.max = max;
    }

    @Override
    public String generate() {
        int op1 = ThreadLocalRandom.current().nextInt(this.op2, this.max + 1);

        return String.format("%s - %s = %n", op1, op2);
    }

}
