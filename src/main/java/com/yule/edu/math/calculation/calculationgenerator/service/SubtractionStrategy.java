package com.yule.edu.math.calculation.calculationgenerator.service;

import java.util.concurrent.ThreadLocalRandom;

public class SubtractionStrategy implements IOperationStrategy {
    private int max;

    public SubtractionStrategy(int max) {
        this.max = max;
    }

    @Override
    public String generate() {
        int op1 = ThreadLocalRandom.current().nextInt(0, this.max + 1);
        int op2 = ThreadLocalRandom.current().nextInt(op1, this.max + 1);

        return String.format("%s - %s = %n", op2, op1);
    }

  public static IOperationStrategy take(Parameters parameters){
    if(parameters.getSubstract().getMax()>0){
      return new SubtractionStrategy(parameters.getSubstract().getMax());
    }
    return null;
  }

}
