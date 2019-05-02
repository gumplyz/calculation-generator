package com.yule.edu.math.calculation.calculationgenerator.service;

import java.util.concurrent.ThreadLocalRandom;

public class AdditionStrategy implements IOperationStrategy {
    private int max;

    public AdditionStrategy(int max) {
        this.max = max;
    }

    @Override
    public String generate() {
        int op1= ThreadLocalRandom.current().nextInt(0, this.max + 1);
        int op2=this.max-op1;
        return String.format("%s + %s = %n", op1, op2);
    }

    public static IOperationStrategy take(Parameters parameters){
        if(parameters.getAdd().getMax()>0){
            return new AdditionStrategy(parameters.getAdd().getMax());
        }
        return null;
    }
}
