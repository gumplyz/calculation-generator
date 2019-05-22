package com.yule.edu.math.calculation.calculationgenerator.service;

import java.util.concurrent.ThreadLocalRandom;

public class SubstractionWithBorrowStrategy implements IOperationStrategy {
  private Parameters.Substract parameters;

  private SubstractionWithBorrowStrategy(Parameters.Substract parameters) {
    this.parameters = parameters;
    this.parameters.setMax(Math.max(20, this.parameters.getMax()));
  }

  @Override
  public String generate() {
    int op1 = ThreadLocalRandom.current().nextInt(2, 10);
    int op2 = ThreadLocalRandom.current().nextInt(1, op1);


    int tens = ((this.parameters.getMax()) / 10) % 10;
    int op2Ten = ThreadLocalRandom.current().nextInt(1, tens);
    int op1Ten = op2Ten - 1;


    return String.format("%s - %s = ", 10 * op2Ten + op2, 10 * op1Ten + op1);
  }


  public static IOperationStrategy take(Parameters parameters) {
    if (parameters.getSubstract() != null) {
      return new SubstractionWithBorrowStrategy(parameters.getSubstract());
    }
    return null;
  }
}
