package com.yule.edu.math.calculation.calculationgenerator.service;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SubtractionStrategy implements IOperationStrategy {
    private Parameters.Substract parameters;

    public SubtractionStrategy(Parameters.Substract parameters) {
        this.parameters = parameters;
    }

    @Override
    public String generate() {
        int[] ops= new int[this.parameters.getNumOps()];

        for (int i = 0; i < this.parameters.getNumOps(); i++) {
            ops[i] = ThreadLocalRandom.current().nextInt(1, this.parameters.getMax() + 1);

        }

        Arrays.sort(ops);
        StringBuilder sb= new StringBuilder();
        for (int i = ops.length-1; i>=1  ; i--) {
            sb.append(ops[i]).append(" - ");
        }

        return  sb.append(ops[0]).append(" = ").toString();
    }

  public static IOperationStrategy take(Parameters parameters){
    if(parameters.getSubstract()!=null){
      return new SubtractionStrategy(parameters.getSubstract());
    }
    return null;
  }

}
